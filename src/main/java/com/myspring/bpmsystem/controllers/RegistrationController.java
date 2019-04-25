package com.myspring.bpmsystem.controllers;

import com.myspring.bpmsystem.models.Employee;
import com.myspring.bpmsystem.models.Role;
import com.myspring.bpmsystem.repositories.EmployeeRepository;
import com.myspring.bpmsystem.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

import static java.util.Collections.singleton;

@Controller
public class RegistrationController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(Employee employee, Map<String, Object> model) {
        Employee employeeFromDb = employeeRepository.findByUsername(employee.getUsername());

        if (employeeFromDb != null) {
            model.put("message", "User exists!");
            return "registration";
        }

        employee.setActive(true);
        employee.setRoles(Collections.singleton(Role.USER));
        employeeService.create(employee);

        return "redirect:/login";
    }
}
