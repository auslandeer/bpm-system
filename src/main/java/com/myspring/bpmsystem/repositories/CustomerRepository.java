package com.myspring.bpmsystem.repositories;

import com.myspring.bpmsystem.models.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
