package com.crazyvaperV2.controller;

import com.crazyvaperV2.entity.User;
import com.crazyvaperV2.service.interfaces.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") long id,
                          @RequestParam(value = "edit", required = false) boolean edit, Model model) {
        model.addAttribute("user", userService.getById(id));
        if (edit) {
            return "editUser";
        }
        return "showUser";
    }

    @GetMapping("/create")
    public String createPage(@RequestParam(value = "message", required = false) String message,
                             Model model) {
        if (message != null) {
            model.addAttribute("message", message);
        }
        return "createUsersForm";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute User user, Model model) {
        userService.save(user);
        return "redirect:all";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:" + user.getId() + "?edit=false";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/all";
    }

    @GetMapping("/all")
    public String showUsers(Model model,
                            @RequestParam(value = "page", required = false) Integer page,
                            @RequestParam(value = "size", required = false) Integer size,
                            @RequestParam(value = "order", required = false) String order,
                            @RequestParam(value = "direction", required = false) String direction){
        Page<User> pages;
        List<User> all;
        int totalPages = 0;
        if (size == null){
            size = 10;
        }
        if (StringUtils.isEmpty(order)) {
            order = "id";
            direction = "low";
        }
        if (page != null) {
            pages = userService.getAll(page, size, order, direction);
            totalPages = pages.getTotalPages();
            model.addAttribute("total", totalPages);
            model.addAttribute("users", pages.getContent());
            model.addAttribute("order", order);
            model.addAttribute("direction", direction);
        } else if ((!StringUtils.isEmpty(order)) && (!StringUtils.isEmpty(direction))) {
            pages = userService.getAll(0, 10, order, direction);
            totalPages = pages.getTotalPages();
            model.addAttribute("total", totalPages);
            model.addAttribute("users", pages.getContent());
            model.addAttribute("order", order);
            model.addAttribute("direction", direction);
        } else {
            all = userService.getAll();
            model.addAttribute("users", all);
            totalPages = all.size()/size;
        }

        List<Integer> pagesCount = new ArrayList<>();
        for (int i = 0; i < totalPages; i++) {
            pagesCount.add(i);
        }
        model.addAttribute("pages", pagesCount);

        return "usersList";
    }
}
