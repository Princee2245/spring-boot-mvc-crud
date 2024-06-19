package com.luv2code.springboot.thymleafDemo.dao;

import com.luv2code.springboot.thymleafDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!


    //add a method to sort by last name
    // it will automatically write q query for us
    public List<Employee> findAllByOrderByLastNameAsc();
}
