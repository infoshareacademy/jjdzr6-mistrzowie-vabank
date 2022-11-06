package com.infoshareacademy.mistrzowieVaBank.controller;

import com.infoshareacademy.mistrzowieVaBank.dao.WineDao;
import com.infoshareacademy.mistrzowieVaBank.dto.CartInfo;
import com.infoshareacademy.mistrzowieVaBank.dto.NewWineInfo;
import com.infoshareacademy.mistrzowieVaBank.dto.WineInfo;
import com.infoshareacademy.mistrzowieVaBank.entity.Wine;
import com.infoshareacademy.mistrzowieVaBank.service.WineListService;
import com.infoshareacademy.mistrzowieVaBank.utils.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@Controller
@Transactional
public class ProductController {

    private final WineDao wineDao;

    private final WineListService wineListService;

    public ProductController(WineDao wineDao, WineListService wineListService) {
        this.wineDao = wineDao;
        this.wineListService = wineListService;
    }

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

    @RequestMapping("/wine/{id}")
    public String findWine(@PathVariable() Long id, Model model) {
        model.addAttribute("wine", wineDao.findWine(id));
        return "wine";
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

        }
    }
}
