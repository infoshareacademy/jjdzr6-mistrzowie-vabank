package com.infoshareacademy.mistrzowieVaBank.controller;

import com.infoshareacademy.mistrzowieVaBank.dao.OrderDao;
import com.infoshareacademy.mistrzowieVaBank.dao.WineDao;
import com.infoshareacademy.mistrzowieVaBank.dto.CartInfo;
import com.infoshareacademy.mistrzowieVaBank.dto.CustomerInfo;
import com.infoshareacademy.mistrzowieVaBank.dto.WineInfo;
import com.infoshareacademy.mistrzowieVaBank.entity.Wine;
import com.infoshareacademy.mistrzowieVaBank.form.CustomerForm;
import com.infoshareacademy.mistrzowieVaBank.utils.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@Transactional
public class ShoppingCartController {
    private final WineDao wineDao;
    private final OrderDao orderDAO;

    public ShoppingCartController(WineDao wineDao, OrderDao orderDAO) {
        this.wineDao = wineDao;
        this.orderDAO = orderDAO;
    }

    @RequestMapping({"/shoppingCartRemoveProduct"})
    public String removeProductHandler(HttpServletRequest request,
                                       @RequestParam(value = "id", defaultValue = "") Long id) {
        Wine product = null;
        if (id != null) {
            product = wineDao.findWine(id);
        }
        if (product != null) {

            CartInfo cartInfo = Utils.getCartInSession(request);

            WineInfo productInfo = new WineInfo(product);

            cartInfo.removeProduct(productInfo);

        }

        return "redirect:/shoppingCart";
    }

    // POST: Update quantity for product in cart
    @RequestMapping(value = {"/shoppingCart"}, method = RequestMethod.POST)
    public String shoppingCartUpdateQty(HttpServletRequest request, //
                                        @ModelAttribute("cartForm") CartInfo cartForm) {

        CartInfo cartInfo = Utils.getCartInSession(request);
        cartInfo.updateQuantity(cartForm);

        return "redirect:/shoppingCart";
    }

    // GET: Show cart.
    @RequestMapping(value = {"/shoppingCart"}, method = RequestMethod.GET)
    public String shoppingCartHandler(HttpServletRequest request, Model model) {
        CartInfo myCart = Utils.getCartInSession(request);
        CartInfo cartInfo = Utils.getCartInSession(request);

        model.addAttribute("cartForm", cartInfo);
        model.addAttribute("myCart", myCart);
        return "shoppingCart";
    }

    // GET: Enter customer information.
    @RequestMapping(value = {"/shoppingCartCustomer"}, method = RequestMethod.GET)
    public String shoppingCartCustomerForm(HttpServletRequest request, Model model) {

        CartInfo cartInfo = Utils.getCartInSession(request);

        if (cartInfo.isEmpty()) {

            return "redirect:/shoppingCart";
        }
        CustomerInfo customerInfo = cartInfo.getCustomerInfo();

        CustomerForm customerForm = new CustomerForm(customerInfo);

        model.addAttribute("customerForm", customerForm);

        return "shoppingCartCustomer";
    }

    // POST: Save customer information.
    @RequestMapping(value = {"/shoppingCartCustomer"}, method = RequestMethod.POST)
    public String shoppingCartCustomerSave(HttpServletRequest request, //
                                           @ModelAttribute("customerForm") @Validated CustomerForm customerForm, //
                                           BindingResult result) {

        if (result.hasErrors()) {
            customerForm.setValid(false);
            // Forward to reenter customer info.
            return "shoppingCartCustomer";
        }

        customerForm.setValid(true);
        CartInfo cartInfo = Utils.getCartInSession(request);
        CustomerInfo customerInfo = new CustomerInfo(customerForm);
        cartInfo.setCustomerInfo(customerInfo);

        return "redirect:/shoppingCartConfirmation";
    }

    // GET: Show information to confirm.
    @RequestMapping(value = {"/shoppingCartConfirmation"}, method = RequestMethod.GET)
    public String shoppingCartConfirmationReview(HttpServletRequest request, Model model) {
        CartInfo cartInfo = Utils.getCartInSession(request);

        if (cartInfo == null || cartInfo.isEmpty()) {

            return "redirect:/shoppingCart";
        } else if (!cartInfo.isValidCustomer()) {

            return "redirect:/shoppingCartCustomer";
        }
        model.addAttribute("myCart", cartInfo);

        return "shoppingCartConfirmation";
    }

    // POST: Submit Cart (Save)
    @RequestMapping(value = {"/shoppingCartConfirmation"}, method = RequestMethod.POST)

    public String shoppingCartConfirmationSave(HttpServletRequest request) {
        CartInfo cartInfo = Utils.getCartInSession(request);

        if (cartInfo.isEmpty()) {

            return "redirect:/shoppingCart";
        } else if (!cartInfo.isValidCustomer()) {

            return "redirect:/shoppingCartCustomer";
        }
        try {
            orderDAO.saveOrder(cartInfo);
        } catch (Exception e) {

            return "shoppingCartConfirmation";
        }

        // Remove Cart from Session.
        Utils.removeCartInSession(request);

        // Store last cart.
        Utils.storeLastOrderedCartInSession(request, cartInfo);

        return "redirect:/shoppingCartFinalize";
    }

    @RequestMapping(value = {"/shoppingCartFinalize"}, method = RequestMethod.GET)
    public String shoppingCartFinalize(HttpServletRequest request, Model model) {

        CartInfo lastOrderedCart = Utils.getLastOrderedCartInSession(request);

        if (lastOrderedCart == null) {
            return "redirect:/shoppingCart";
        }
        model.addAttribute("lastOrderedCart", lastOrderedCart);
        return "shoppingCartFinalize";
    }
}
