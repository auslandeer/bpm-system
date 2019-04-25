package com.myspring.bpmsystem.services;

import com.myspring.bpmsystem.models.Employee;
import com.myspring.bpmsystem.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return employeeRepository.findByUsername(username);
    }

    public List<Employee > read(){
        return (List<Employee>) employeeRepository.findAll();
    }

    public Employee create(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee update(Employee employee){
        return employeeRepository.save(employee);
    }

    public void delete(Integer id){
        employeeRepository.deleteById(id);
    }
}
