package com.crazyvaperV2.controller;

import com.crazyvaperV2.entity.Cart;
import com.crazyvaperV2.entity.Product;
import com.crazyvaperV2.service.interfaces.CartServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartServise cartServise;

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") long id,
                          @RequestParam(value = "edit", required = false) boolean edit, Model model) {
        model.addAttribute("cart", cartServise.getById(id));
        if (edit) {
            return "editCart";
        }
        return "showCart";
    }

    @GetMapping("/all")
    public String showCart(Model model,
                            @RequestParam(value = "page", required = false) Integer page,
                            @RequestParam(value = "size", required = false) Integer size,
                            @RequestParam(value = "order", required = false) String order,
                            @RequestParam(value = "direction", required = false) String direction){
        Page<Cart> pages;
        List<Cart> all;
        int totalPages = 0;
        if (size == null){
            size = 10;
        }
        if (StringUtils.isEmpty(order)) {
            order = "id";
            direction = "low";
        }
        if (page != null) {
            pages = cartServise.getAll(page, size, order, direction);
            totalPages = pages.getTotalPages();
            model.addAttribute("total", totalPages);
            model.addAttribute("cartList", pages.getContent());
            model.addAttribute("order", order);
            model.addAttribute("direction", direction);
        } else if ((!StringUtils.isEmpty(order)) && (!StringUtils.isEmpty(direction))) {
            pages = cartServise.getAll(0, 10, order, direction);
            totalPages = pages.getTotalPages();
            model.addAttribute("total", totalPages);
            model.addAttribute("cartList", pages.getContent());
            model.addAttribute("order", order);
            model.addAttribute("direction", direction);
        } else {
            all = cartServise.getAll();
            model.addAttribute("cartList", all);
            totalPages = all.size()/size;
        }

        List<Integer> pagesCount = new ArrayList<>();
        for (int i = 0; i < totalPages; i++) {
            pagesCount.add(i);
        }
        model.addAttribute("pages", pagesCount);

        return "cartList";
    }

    @GetMapping("/create")
    public String createPage(@RequestParam(value = "message", required = false) String message,
                             Model model) {
        if (message != null) {
            model.addAttribute("message", message);
        }
        return "createCartForm";
    }

    @PostMapping("/create")
    public String createCart(@ModelAttribute Cart cart) {
        cartServise.save(cart);
        return "redirect:showCart";
    }
}
