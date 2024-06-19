package com.luv2code.cruddemo.DAO;

import com.luv2code.cruddemo.entity.Instructor;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.Retention;

@Repository
public class AppDAPImpl implements AppDAO{

    private EntityManager entityManager;

    @Autowired
    public AppDAPImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class,id);
    }

    @Override
    @Transactional
    public void deleteInstructorId(int id) {
        Instructor tempInstructor=entityManager.find(Instructor.class,id);
        entityManager.remove(tempInstructor);
    }
}
