package com.crazyvaperV2.controller;

import com.crazyvaperV2.entity.ELiquid;
import com.crazyvaperV2.service.interfaces.ELiquidService;
import com.crazyvaperV2.service.interfaces.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/eliquid")
public class ELiquidController {

    private static final Logger logger = Logger.getLogger(ELiquidController.class);

    @Autowired
    private ELiquidService eLiquidService;

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public String showELiquid(Model model,
                            @RequestParam(value = "page", required = false) Integer page,
                            @RequestParam(value = "size", required = false) Integer size,
                            @RequestParam(value = "order", required = false) String order,
                            @RequestParam(value = "direction", required = false) String direction){
        Page<ELiquid> pages;
        List<ELiquid> all;
        int totalPages = 0;
        if (size == null){
            size = 10;
        }
        if (StringUtils.isEmpty(order)) {
            order = "id";
            direction = "low";
        }
        if (page != null) {
            pages = eLiquidService.getAll(page, size, order, direction);
            totalPages = pages.getTotalPages();
            model.addAttribute("total", totalPages);
            model.addAttribute("goodsList", pages.getContent());
            model.addAttribute("order", order);
            model.addAttribute("direction", direction);
        } else if ((!StringUtils.isEmpty(order)) && (!StringUtils.isEmpty(direction))) {
            pages = eLiquidService.getAll(0, 10, order, direction);
            totalPages = pages.getTotalPages();
            model.addAttribute("total", totalPages);
            model.addAttribute("goodsList", pages.getContent());
            model.addAttribute("order", order);
            model.addAttribute("direction", direction);
        } else {
            all = eLiquidService.getAll();
            model.addAttribute("goodsList", all);
            totalPages = all.size()/size;
        }

        List<Integer> pagesCount = new ArrayList<>();
        for (int i = 0; i < totalPages; i++) {
            pagesCount.add(i);
        }
        if (!pagesCount.isEmpty()) {
            model.addAttribute("pages", pagesCount);
        }
        return "eliquidList";
    }

    @GetMapping("/create")
    public String createPage(@RequestParam(value = "message", required = false) String message,
                             Model model) {
        if (message != null) {
            model.addAttribute("message", message);
        }
        return "createELiquidForm";
    }

    @PostMapping("/create")
    public String createELiquid(@ModelAttribute ELiquid eLiquid) {
        eLiquid.setUpdatedTime(new Date(System.currentTimeMillis()));
        productService.save(eLiquid);
        return "redirect:all";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") long id,
                          @RequestParam(value = "edit", required = false) boolean edit, Model model) {
        model.addAttribute("eLiquid", productService.getById(id));
        if (edit) {
            return "editELiquid";
        }
        return "showELiquid";
    }

    @PostMapping("/update")
    public String editELiquid(@ModelAttribute ELiquid eLiquid) {
        eLiquid.setUpdatedTime(new Date(System.currentTimeMillis()));
        productService.save(eLiquid);
        return "redirect:" + eLiquid.getId() + "?edit=false";
    }

    @GetMapping("/delete/{id}")
    public String deleteELiquid(@PathVariable("id") long id) {
        productService.delete(id);
        return "redirect:/eliquid/all";
    }

}
