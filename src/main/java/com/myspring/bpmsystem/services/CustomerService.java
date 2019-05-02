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

    PriorityQueue<Customer> sendCustomers2 = new PriorityQueue<Customer>();

    PriorityQueue<Customer> sendCustomers3 = new PriorityQueue<Customer>();

    PriorityQueue<Customer> sendCustomers4 = new PriorityQueue<>();

    PriorityQueue<Customer> revision = new PriorityQueue<>();

    PriorityQueue<Customer> revisionStep3 = new PriorityQueue<>();

    PriorityQueue<Customer> revisionStep4 = new PriorityQueue<>();

    List<Customer> refused = new ArrayList<>();

    List<Customer> approved = new ArrayList<>();

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

    public void sendStep3(Customer customer){
        this.sendCustomers3.add(customer);
    }

    public Customer takeStep3(){
        Customer customer = sendCustomers3.peek();
        return customer;
    }

    public void sendStep4(Customer customer){
        this.sendCustomers4.add(customer);
    }

    public Customer takeStep4(){
        Customer customer = sendCustomers4.peek();
        return customer;
    }

    public void sendRevision(Customer customer){
        this.revision.add(customer);
    }

    public Customer takeRevision(){
        return this.revision.peek();
    }

    public void sendRevision3(Customer customer){
        this.revisionStep3.add(customer);
    }

    public Customer takeRevision3(){
        return this.revisionStep3.peek();
    }

    public void sendRevision4(Customer customer){
        this.revisionStep4.add(customer);
    }

    public Customer takeRevision4(){
        return this.revisionStep4.peek();
    }

    public void sendRefused(Customer customer){
        this.refused.add(customer);
    }

    public void sendApproved(Customer customer){
        this.approved.add(customer);
    }

    public List<Customer> refusedList(){
        return this.refused;
    }

    public List<Customer> approvedList(){
        return this.approved;
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
