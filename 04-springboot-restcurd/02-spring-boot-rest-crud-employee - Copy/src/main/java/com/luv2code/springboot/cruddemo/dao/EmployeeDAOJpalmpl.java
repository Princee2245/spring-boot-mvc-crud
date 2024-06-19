package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Queue;

@Repository
public class EmployeeDAOJpalmpl implements EmployeeDAO{

    //define field
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpalmpl(EntityManager theEntityManger){
        entityManager=theEntityManger;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery=entityManager.createQuery("from Employee",Employee.class);
        List<Employee> employees=theQuery.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int id) {
        Employee emp=entityManager.find(Employee.class,id);
        return emp;
    }

    @Override
    public Employee save(Employee emp) {
       Employee dbEmp=entityManager.merge(emp);
       return dbEmp;
    }

    @Override
    public void deleyeById(int id) {
        Employee emp=entityManager.find(Employee.class,id);
        entityManager.remove(emp);
    }
}
