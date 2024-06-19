package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void loadData(){
        students=new LinkedList<>();
        students.add(new Student("Prince","Pansuriya"));
        students.add(new Student("Shivam","Pansuriya"));
        students.add(new Student("Ritik","Pansuriya"));
    }

    @GetMapping("/students")
    public List<Student> getStudent(){
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        if(studentId>=students.size() || studentId<0){
            throw new StudentNotFoundException("Student id not found "+studentId);

        }

        return students.get(studentId);
    }




}
