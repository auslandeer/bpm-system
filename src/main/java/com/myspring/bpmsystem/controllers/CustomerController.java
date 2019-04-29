package com.myspring.bpmsystem.controllers;

import com.myspring.bpmsystem.models.Customer;
import com.myspring.bpmsystem.services.CustomerService;
import com.myspring.bpmsystem.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String mainPage(){
        return "mainCustomer";
    }

    @GetMapping("/addCustomer")
    public String addCustomerPage(){
        return "addCustomer";
    }

//    @GetMapping("/step_2")
//    public String step2Page(Map<String, Customer> model){
//        Customer customer = customerService.takeStep2();
//        model.put("customer", customer);
//        return "step_2";
//    }

    @PostMapping("/step_2")
    public String step2( Customer customer){

        if(customer!=null){
//            customer.setId(0);
            customerService.sendStep2(customer);
        }
        return "redirect:/customer/addCustomer";
    }



    @GetMapping("/read")
    public List<Customer> read() {
        return customerService.read();
    }

    @PutMapping(value = "/create")
    public Customer create(@RequestBody Customer customer) {
        return customerService.create(customer);
    }

    @PostMapping(value = "/update")
    public Customer update(@RequestBody Customer customer) {
        return customerService.update(customer);
    }

    @DeleteMapping(value = "/delete")
    public void delete(@RequestParam(name = "id") Integer id) {
        customerService.delete(id);
    }

}

