package com.infoshareacademy.mistrzowieVaBank.controller;

import com.infoshareacademy.mistrzowieVaBank.dao.WineDao;
import com.infoshareacademy.mistrzowieVaBank.entity.Wine;
import com.infoshareacademy.mistrzowieVaBank.service.WineListService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
@Transactional
public class WineController {

    private final WineListService wineListService;

    private final WineDao wineDao;

    private static final int pageSize = 10;

    public WineController(WineListService wineListService, WineDao wineDao) {
        this.wineListService = wineListService;
        this.wineDao = wineDao;
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

    @GetMapping("/winelist/image/{id}")
    public void showProductImage(@PathVariable Long id,
                                 HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg/png");

        Wine find = wineDao.findWine(id);

        InputStream is = new ByteArrayInputStream(find.getImage());
        IOUtils.copy(is, response.getOutputStream());

    }
}
