package com.infoshareacademy.mistrzowieVaBank.controller;


import com.infoshareacademy.mistrzowieVaBank.dao.OrderDao;
import com.infoshareacademy.mistrzowieVaBank.dao.WineDao;
import com.infoshareacademy.mistrzowieVaBank.dto.CartInfo;
import com.infoshareacademy.mistrzowieVaBank.dto.CustomerInfo;
import com.infoshareacademy.mistrzowieVaBank.dto.NewWineInfo;
import com.infoshareacademy.mistrzowieVaBank.dto.WineInfo;
import com.infoshareacademy.mistrzowieVaBank.entity.Wine;
import com.infoshareacademy.mistrzowieVaBank.form.CustomerForm;
import com.infoshareacademy.mistrzowieVaBank.repository.WineRepository;
import com.infoshareacademy.mistrzowieVaBank.service.WineListService;
import com.infoshareacademy.mistrzowieVaBank.utils.Utils;
import com.infoshareacademy.mistrzowieVaBank.validator.CustomerFormValidator;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
@Transactional
public class MainController {

    @Autowired
    private OrderDao orderDAO;

    @Autowired
    private WineDao wineDao;

    @Autowired
    private CustomerFormValidator customerFormValidator;

    @Autowired
    private WineListService wineListService;

    @Autowired
    private WineRepository wineRepository;

    private static final int pageSize = 5;


    @InitBinder
    public void myInitBinder(WebDataBinder dataBinder) {
        Object target = dataBinder.getTarget();
        if (target == null) {
            return;
        }
        System.out.println("Target=" + target);
        //TODO
        // Case update quantity in cart
        // (@ModelAttribute("cartForm") @Validated CartInfo cartForm)
        if (target.getClass() == CartInfo.class) {
        }

        // Case save customer information.
        // (@ModelAttribute @Validated CustomerInfo customerForm)
        else if (target.getClass() == CustomerForm.class) {
            dataBinder.setValidator(customerFormValidator);
        }

    }

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    // Product List

    @RequestMapping({"/buyProduct"})
    public String listProductHandler(HttpServletRequest request,
                                     @RequestParam(value = "id", defaultValue = "") Long id) {

        Wine wine = null;
        if (id != null) {
            wine = wineDao.findWine(id);
        }
        if (wine != null) {

            //
            CartInfo cartInfo = Utils.getCartInSession(request);

            WineInfo wineInfo = new WineInfo(wine);

            cartInfo.addProduct(wineInfo, 1);
        }

        return "redirect:/shoppingCart";
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

    @RequestMapping(value = {"/productImage"}, method = RequestMethod.GET)
    public void productImage(HttpServletRequest request, HttpServletResponse response,
                             @RequestParam("id") Long id) throws IOException {
        Wine wine = null;
        if (id != null) {
            wine = this.wineDao.findWine(id);
        }
        if (wine != null && wine.getImage() != null) {
            response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
            response.getOutputStream().write(wine.getImage());
        }
        response.getOutputStream().close();
    }


    @RequestMapping(value = "/winelist", method = RequestMethod.GET)
    public String showWineList(Model model) {
        model.addAttribute("wines", wineListService.findPaginated(1, pageSize, null, null));
        return "winelist";
    }

    @GetMapping("/winelist/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model,
                                @RequestParam(value = "sortField", required = false) String sortField,
                                @RequestParam(value = "sortDir", required = false) String sortDir) {

        if (sortField == null) {
            sortField = "name";
        }

        if (sortDir == null) {
            sortDir = "asc";
        }

        Page<Wine> page = wineListService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Wine> wineList = page.getContent();

        model.addAttribute("prevPage", pageNo - 1);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("nextPage", pageNo + 1);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("wines", wineList);

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");


        return "winelist";
    }

    @RequestMapping("/wine/{id}")
    public String findWine(@PathVariable() Long id, Model model) {
        model.addAttribute("wine", wineDao.findWine(id));
        return "wine";
    }

    @RequestMapping("/orderlist")
    public String showOrderList(Model model) {
        model.addAttribute("order", orderDAO.getAllOrders());
        return "orderlist";
    }

    @RequestMapping({"/removeOrder={orderNum}"})
    public String removeOrder(@PathVariable int orderNum) {
        orderDAO.deleteOrderByOrderNum(orderNum);
        return "redirect:/orderlist";
    }

    @RequestMapping({"/setrealized={orderNum}"})
    public String setOrderAsRealized(@PathVariable int orderNum) {
        orderDAO.setOrderAsRealized(orderNum);
        return "redirect:/orderlist";
    }

    @RequestMapping({"/order={orderNum}"})
    public String singleOrderPage(@PathVariable int orderNum, Model model) {
        model.addAttribute("order", orderDAO.findAllByOrderNum(orderNum));
        return "order";
    }

    @RequestMapping(value = {"/newwineform"}, method = RequestMethod.GET)
    public String NewWineForm(NewWineInfo newWineInfo, Model model) {

        model.addAttribute("newwineform", newWineInfo);
        return "newWineForm";
    }


    @RequestMapping(value = {"/newwineform"}, method = RequestMethod.POST)
    public String newWineForm(@Valid @ModelAttribute("newwineform") NewWineInfo newWineInfo, BindingResult bindingResult,
                              @RequestParam(value = "image", required = false) MultipartFile multipartFile) throws IOException {


        if (bindingResult.hasErrors()) {
            return "newWineForm";
        } else {
            if (wineListService.ifExist(newWineInfo.getName())) {
                bindingResult.rejectValue("name", "error.name", "Name is already taken. Choose another one.");
                return "newWineForm";
            } else {
                if (multipartFile != null) {
                    newWineInfo.setFile(multipartFile.getBytes());
                }
                wineDao.saveNewWine(newWineInfo);
                return "redirect:/winelist/page/1";
            }

//wineDao wyciagnac nazwe i sprawdzic + dodac do bindingresults / if / add error bindingresults / poczytac jak dodac blad
            //zobaczyc Validatora
           /* if(wineRepository.findWineByName(newWineInfo.getName()) != null){
                ObjectError error = new ObjectError("name_use","Name is already used, try other name.");
                bindingResult.addError(error);*/
        }
    }

    @GetMapping("/winelist/image/{id}")
    public void showProductImage(@PathVariable Long id,
                                 HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg/png");

        Wine find = wineDao.findWine(id);

            InputStream is = new ByteArrayInputStream(find.getImage());
            IOUtils.copy(is, response.getOutputStream());

    }
}


