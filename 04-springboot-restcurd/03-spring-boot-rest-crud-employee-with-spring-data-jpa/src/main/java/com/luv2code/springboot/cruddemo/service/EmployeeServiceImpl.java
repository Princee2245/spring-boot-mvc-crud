package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result=employeeRepository.findById(id);
        Employee emp=null;

        if(result.isPresent()){
            emp=result.get();
        }else{
            throw new RuntimeException("Did not find employee id");
        }
        return  emp;
    }

    @Override
    public Employee save(Employee emp) {
        return employeeRepository.save(emp);
    }

    @Override
    public void deleyeById(int id) {
        employeeRepository.deleteById(id);
    }
}
