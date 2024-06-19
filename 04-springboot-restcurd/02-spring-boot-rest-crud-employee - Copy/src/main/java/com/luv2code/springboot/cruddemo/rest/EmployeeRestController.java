package com.luv2code.springboot.cruddemo.rest;


import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
//    private EmployeeDAO employeeDAO;

    private EmployeeService employeeService;
//    public EmployeeRestController(EmployeeDAO empdao){
//        employeeDAO=empdao;
//    }

    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmp=employeeService.findById(employeeId);

        if(theEmp==null){
            throw new RuntimeException("Employee not found- "+employeeId);

        }
        return theEmp;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){

        //this is to force a save of new items ... instead of update
        theEmployee.setId(0);
        Employee dbEmp=employeeService.save(theEmployee);
        return dbEmp;
    }

    @PutMapping("/employees")
    public Employee updateEmployees(@RequestBody Employee emp){
        Employee dbemp=employeeService.save(emp);
        return dbemp;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployees(@PathVariable int employeeId){
        Employee emp=employeeService.findById(employeeId);
        if(emp==null){
            throw new RuntimeException("Emp does not exist");
        }
        employeeService.deleyeById(employeeId);
        return "Deleted emp id  "+employeeId;
    }
}
