package com.myspring.bpmsystem.repositories;

import com.myspring.bpmsystem.models.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    Employee findByUsername(String username);
}
