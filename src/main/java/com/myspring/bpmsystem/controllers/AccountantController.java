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
import org.springframework.web.bind.annotation.RestController;

@Controller
@PreAuthorize("hasAuthority('ACCOUNTANT') or hasAuthority('ADMIN')")
@RequestMapping("/accountant")
public class AccountantController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/step_3")
    public String step3(Model model){
        Customer customer = customerService.takeStep3();
        model.addAttribute("customer", customer);
        return "step_3";
    }

     @PostMapping("/revision")
     public String revision(Customer customer){
        customerService.sendRevision3(customer);
        return "step_3";
     }

     @PostMapping("/refuse")
    public  String refuse(Customer customer){
        customerService.sendRefused(customer);
        return "step_3";
     }

     @PostMapping("/step_4")
    public String step4(Customer customer,
                        Model model){
        String message = null;
        if (customer!=null){
            customerService.sendStep4(customer);
            message = "customer send!";
        }
        model.addAttribute("message", message);
        return "step_3";

     }

}
