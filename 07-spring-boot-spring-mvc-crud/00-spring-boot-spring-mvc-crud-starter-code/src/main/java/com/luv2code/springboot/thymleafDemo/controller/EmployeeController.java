package com.luv2code.springboot.thymleafDemo.controller;

import com.luv2code.springboot.thymleafDemo.entity.Employee;
import com.luv2code.springboot.thymleafDemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel){
        List<Employee> theEmployees=employeeService.findAll();

        theModel.addAttribute("employees",theEmployees);
        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showForm(Model theModel){
        Employee theEmployee=new Employee();
        theModel.addAttribute("employee",theEmployee);
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("employee") Employee theEmployee){
        employeeService.save(theEmployee);
    return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String update(@RequestParam("employeeId") int theId,Model theModel){

        Employee theEmployee=employeeService.findById(theId);

        theModel.addAttribute("employee",theEmployee);

        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId){
        employeeService.deleteById(theId);
        return "redirect:/employees/list";
    }
}
