package com.crazyvaperV2.controller;

import com.crazyvaperV2.entity.ECig;
import com.crazyvaperV2.service.interfaces.ECigService;
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
@RequestMapping("/ecig")
public class ECigController {

    private static final Logger logger = Logger.getLogger(ECigController.class);

    @Autowired
    private ECigService eCigService;

    @GetMapping("/all")
    public String showEcigs(Model model,
                            @RequestParam(value = "page", required = false) Integer page,
                            @RequestParam(value = "size", required = false) Integer size,
                            @RequestParam(value = "order", required = false) String order,
                            @RequestParam(value = "direction", required = false) String direction){
        Page<ECig> pages;
        List<ECig> all;
        int totalPages = 0;
        if (size == null){
            size = 10;
        }
        if (StringUtils.isEmpty(order)) {
            order = "id";
            direction = "low";
        }
        if (page != null) {
            pages = eCigService.getAll(page, size, order, direction);
            totalPages = pages.getTotalPages();
            model.addAttribute("total", totalPages);
            model.addAttribute("goodsList", pages.getContent());
            model.addAttribute("order", order);
            model.addAttribute("direction", direction);
        } else if ((!StringUtils.isEmpty(order)) && (!StringUtils.isEmpty(direction))) {
            pages = eCigService.getAll(0, 10, order, direction);
            totalPages = pages.getTotalPages();
            model.addAttribute("total", totalPages);
            model.addAttribute("goodsList", pages.getContent());
            model.addAttribute("order", order);
            model.addAttribute("direction", direction);
        } else {
            all = eCigService.getAll();
            model.addAttribute("goodsList", all);
            totalPages = all.size()/size;
        }

        List<Integer> pagesCount = new ArrayList<>();
        for (int i = 0; i < totalPages; i++) {
            pagesCount.add(i);
        }
        model.addAttribute("pages", pagesCount);

        return "ecigsList";
    }

    @GetMapping("/create")
    public String createPage(@RequestParam(value = "message", required = false) String message,
                             Model model) {
        if (message != null) {
            model.addAttribute("message", message);
        }
        return "createECigsForm";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute ECig eCig) {
        eCig.setUpdatedTime(new Date(System.currentTimeMillis()));
        eCigService.save(eCig);
        return "redirect:all";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") long id,
                          @RequestParam(value = "edit", required = false) boolean edit, Model model) {
        model.addAttribute("eCig", eCigService.getById(id));
        if (edit) {
            return "editECig";
        }
        return "showECig";
    }

    @PostMapping("/update")
    public String editECigs(@ModelAttribute ECig eCig) {
        eCig.setUpdatedTime(new Date(System.currentTimeMillis()));
        eCigService.save(eCig);
        return "redirect:" + eCig.getId() + "?edit=false";
    }

    @GetMapping("/delete/{id}")
    public String deleteECigs(@PathVariable("id") long id) {
        eCigService.delete(id);
        return "redirect:/ecig/all";
    }
}
