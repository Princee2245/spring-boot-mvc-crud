package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);
    Student fingById(Integer id);

    List<Student> findAll();
    List<Student> findByLastName(String theLastNAme);
    void update(Student s);
    void delete(Integer id);

    int deleteAll();
}
