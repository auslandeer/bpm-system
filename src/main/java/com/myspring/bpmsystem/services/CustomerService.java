package com.myspring.bpmsystem.services;

import com.myspring.bpmsystem.models.Customer;
import com.myspring.bpmsystem.models.Employee;
import com.myspring.bpmsystem.repositories.CustomerRepository;
import org.hibernate.ObjectDeletedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

//    private List<String> ListOfKeys = null;
//    private List<Object> ListOfValues = null;

    private List<Customer> sendCustomers = new ArrayList<>();
    PriorityQueue<Customer> sendCustomers2 = new PriorityQueue<Customer>();

    PriorityQueue<Customer> revision = new PriorityQueue<>();

    public List<Customer> read(){
        return (List<Customer>) customerRepository.findAll();
    }

    public Customer create(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer update(Customer customer){
        return customerRepository.save(customer);
    }

    public void delete(Integer id){
        customerRepository.deleteById(id);
    }

    public void sendStep2(Customer customer){
//        this.sendCustomers.add(customer);
        this.sendCustomers2.add(customer);
    }

    public Customer takeStep2(){
//        Customer customer = sendCustomers.get(0);
//        sendCustomers.remove(0);
        Customer customer = sendCustomers2.peek();
        return customer;
    }

    public void sendRevision(Customer customer){
        this.revision.add(customer);
    }

    public Customer takeRevision(){
        return this.revision.peek();
    }


//    public void sendToStep2(Map<String, Object> model){
//        ListOfKeys = model.keySet().stream().collect(Collectors.
//                toCollection(ArrayList::new));
//        ListOfValues = model.values().stream().collect(Collectors.
//                toCollection(ArrayList::new));
//    }

//    public Map<String, Object> takeStep2(){
//        return
//    }
}
