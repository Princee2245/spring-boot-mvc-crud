package com.luv2code.cruddemo.DAO;


import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int id);
    void deleteInstructorId(int id);
    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

}
