package com.crazyvaperV2.controller;

import com.crazyvaperV2.entity.Payment;
import com.crazyvaperV2.service.interfaces.PaymentService;
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
@RequestMapping("/payment")
public class PaymentController {

    private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") long id,
                          @RequestParam(value = "edit", required = false) boolean edit, Model model) {
        model.addAttribute("payment", paymentService.getById(id));
        if (edit) {
            return "editPayment";
        }
        return "showPayment";
    }

    @GetMapping("/create")
    public String createPage(@RequestParam(value = "message", required = false) String message,
                             Model model) {
        if (message != null) {
            model.addAttribute("message", message);
        }
        return "createPaymentForm";
    }

    @PostMapping("/create")
    public String createPayment(@ModelAttribute Payment payment, Model model) {
        paymentService.save(payment);
        return "redirect:all";
    }

    @PostMapping("/update")
    public String updatePayment(@ModelAttribute Payment payment) {
        paymentService.save(payment);
        return "redirect:" + payment.getId() + "?edit=false";
    }

    @GetMapping("/delete/{id}")
    public String deletePayment(@PathVariable("id") long id) {
        paymentService.delete(id);
        return "redirect:/payment/all";
    }

    @GetMapping("/all")
    public String showPayments(Model model,
                            @RequestParam(value = "page", required = false) Integer page,
                            @RequestParam(value = "size", required = false) Integer size,
                            @RequestParam(value = "order", required = false) String order,
                            @RequestParam(value = "direction", required = false) String direction){
        Page<Payment> pages;
        List<Payment> all;
        int totalPages = 0;
        if (size == null){
            size = 10;
        }
        if (StringUtils.isEmpty(order)) {
            order = "id";
            direction = "low";
        }
        if (page != null) {
            pages = paymentService.getAll(page, size, order, direction);
            totalPages = pages.getTotalPages();
            model.addAttribute("total", totalPages);
            model.addAttribute("payments", pages.getContent());
            model.addAttribute("order", order);
            model.addAttribute("direction", direction);
        } else if ((!StringUtils.isEmpty(order)) && (!StringUtils.isEmpty(direction))) {
            pages = paymentService.getAll(0, 10, order, direction);
            totalPages = pages.getTotalPages();
            model.addAttribute("total", totalPages);
            model.addAttribute("payments", pages.getContent());
            model.addAttribute("order", order);
            model.addAttribute("direction", direction);
        } else {
            all = paymentService.getAll();
            model.addAttribute("payments", all);
            totalPages = all.size()/size;
        }

        List<Integer> pagesCount = new ArrayList<>();
        for (int i = 0; i < totalPages; i++) {
            pagesCount.add(i);
        }
        model.addAttribute("pages", pagesCount);

        return "paymentList";
    }
}
