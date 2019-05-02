package com.myspring.bpmsystem.controllers;

import com.myspring.bpmsystem.models.Customer;
import com.myspring.bpmsystem.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@PreAuthorize("hasAuthority('SECURITY') or hasAuthority('ADMIN')")
@RequestMapping("/security")
public class SecurityController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/step_4")
    public String step4(Model model){
        Customer customer = customerService.takeStep4();
        model.addAttribute("customer", customer);
        return "step_4";
    }

    @PostMapping("/revision")
    public String revision(Customer customer){
        customerService.sendRevision4(customer);
        return "step_4";
    }

    @PostMapping("/refuse")
    public  String refuse(Customer customer){
        customerService.sendRefused(customer);
        return "step_4";
    }

    @PostMapping("/confirm")
    public String confirm(Customer customer,
                        Model model){
        String message = null;
        if (customer!=null){
            customerService.sendApproved(customer);
            message = "customer send!";
        }
        model.addAttribute("message", message);
        return "step_4";

    }
}
