package com.crazyvaperV2.controller;

import com.crazyvaperV2.entity.Cart;
import com.crazyvaperV2.entity.Product;
import com.crazyvaperV2.service.interfaces.CartServise;
import com.crazyvaperV2.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartServise cartServise;

    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(value = "page", required = false) Integer page) {
        model.addAttribute("goodsList", productService.getAll());
        return "index";
    }

    @GetMapping("/loginAndRegistration")
    public String loginPage() {
        return "loginAndRegistration";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "index";
    }

    @GetMapping("/error_page")
    public String errorPage() {
        return "errorPage";
    }

//    @PostMapping("/buyProduct")
//    public String buyProduct(Model model,
//                             @ModelAttribute Cart cart){
//        cart.getProductsList().add(productService.getById(productId));
//        cartServise.save(cart);
//        model.addAttribute("cart", cart);
//        return "redirect:showCart";
//    }
}
