package com.myspring.bpmsystem.controllers;

import com.myspring.bpmsystem.models.Customer;
import com.myspring.bpmsystem.models.Employee;
import com.myspring.bpmsystem.services.CustomerService;
import com.myspring.bpmsystem.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('MANAGER')")
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/step_2")
    public String step2Page(Model model){
        Customer customer = customerService.takeStep2();
        model.addAttribute("customer", customer);
        return "step_2";
    }

    @GetMapping("/revision?{customer}")
    public String revision(@PathVariable Customer customer){
        customerService.sendRevision(customer);
        return "redirect:/employee/step_2";
    }

    @GetMapping("/main")
    public String employeePage(){
        return "emp_page";
    }

    @GetMapping("/read")
    public List<Employee> read(){
        return employeeService.read();
    }

    @PutMapping("/create")
    public Employee create(@RequestBody Employee employee){
        return employeeService.create(employee);
    }

    @PostMapping("/update")
    public Employee update(@RequestBody Employee employee){
        return employeeService.update(employee);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam(name = "id") Integer id){
        employeeService.delete(id);
    }






}
