package com.infoshareacademy.mistrzowieVaBank.controller;


import com.infoshareacademy.mistrzowieVaBank.dao.OrderDAO;
import com.infoshareacademy.mistrzowieVaBank.dao.WineDao;
import com.infoshareacademy.mistrzowieVaBank.dto.CartInfo;
import com.infoshareacademy.mistrzowieVaBank.dto.CustomerInfo;
import com.infoshareacademy.mistrzowieVaBank.dto.WineInfo;
import com.infoshareacademy.mistrzowieVaBank.entity.Wine;
import com.infoshareacademy.mistrzowieVaBank.form.CustomerForm;
import com.infoshareacademy.mistrzowieVaBank.pagination.PaginationResult;
import com.infoshareacademy.mistrzowieVaBank.repository.WineListRepository;
import com.infoshareacademy.mistrzowieVaBank.service.WineListService;
import com.infoshareacademy.mistrzowieVaBank.service.WineListServiceImpl;
import com.infoshareacademy.mistrzowieVaBank.service.listaWin;
import com.infoshareacademy.mistrzowieVaBank.utils.Utils;
import com.infoshareacademy.mistrzowieVaBank.validator.CustomerFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@Transactional
public class MainController {

   @Autowired
   private OrderDAO orderDAO;

   @Autowired
   private WineDao wineDao;

   @Autowired
   private CustomerFormValidator customerFormValidator;

   @Autowired
   private WineListService wineListService;

   @Autowired
   private WineListServiceImpl wineListServiceImpl;

   @InitBinder
   public void myInitBinder(WebDataBinder dataBinder) {
      Object target = dataBinder.getTarget();
      if (target == null) {
         return;
      }
      System.out.println("Target=" + target);

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

   @RequestMapping("/403")
   public String accessDenied() {
      return "/403";
   }

   @RequestMapping("/")
   public String home() {
      return "index";
   }

   // Product List
   @RequestMapping({"/winelist"})
   public String listProductHandler(Model model, //
                                    @RequestParam(value = "name", defaultValue = "") String likeName,
                                    @RequestParam(value = "page", defaultValue = "1") int page) {
      final int maxResult = 8;
      final int maxNavigationPage = 10;

      PaginationResult<WineInfo> result = wineDao.queryProducts(page, //
              maxResult, maxNavigationPage, likeName);

      model.addAttribute("winelist", result);
      return "winelist";
   }

   @RequestMapping({"/buyProduct"})
   public String listProductHandler(HttpServletRequest request, Model model, //
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
   public String removeProductHandler(HttpServletRequest request, Model model, //
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
                                       Model model, //
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

      model.addAttribute("cartForm", myCart);
      model.addAttribute("myCart", cartInfo);
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
                                          Model model, //
                                          @ModelAttribute("customerForm") @Validated CustomerForm customerForm, //
                                          BindingResult result, //
                                          final RedirectAttributes redirectAttributes) {

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

   public String shoppingCartConfirmationSave(HttpServletRequest request, Model model) {
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
   public void productImage(HttpServletRequest request, HttpServletResponse response, Model model,
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

//   @GetMapping("/listaWin")
//   public String showWineList(Model model) {
//
//      model.addAttribute("listaWin", wineListService.findAll());
//      return "listaWin";
//
//   }

   @GetMapping("/listaWin")
   public String showWineList(Model model){
      Wine wine = new Wine();
      model.addAttribute("wine", wine);
      return "listaWin";
   }

   //TODO
//   @GetMapping("  ")
//   public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
//                               @RequestParam("sortField") String sortField,
//                               @RequestParam("sortDir") String sortDir,
//                               Model model) {
//      int pageSize = 5;
//
//      Page<Wine> page = wineListServiceImpl.findPaginated(pageNo, pageSize, sortField, sortDir);
//      List<Wine> wineList = page.getContent();
//
//      model.addAttribute("currentPage", pageNo);
//      model.addAttribute("totalPages", page.getTotalPages());
//      model.addAttribute("totalItems", page.getTotalElements());
//
//      model.addAttribute("sortField", sortField);
//      model.addAttribute("sortDir", sortDir);
//      model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
//
//      model.addAttribute("wine", wineList);
//      return "listaWin";
//   }
}