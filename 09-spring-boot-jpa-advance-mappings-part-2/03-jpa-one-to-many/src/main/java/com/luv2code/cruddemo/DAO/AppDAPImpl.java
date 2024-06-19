package com.luv2code.cruddemo.DAO;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.Retention;
import java.util.List;

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



    @Override
    public InstructorDetail findInstructorDetailById(int id) {
       return entityManager.find(InstructorDetail.class,id);
    }

//    @Override
//    @Transactional
//    public void deleteInstructorDetailById(int id) {
//        InstructorDetail instructorDetail=entityManager.find(InstructorDetail.class,id);
//        entityManager.remove(instructorDetail);
//    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        InstructorDetail instructorDetail=entityManager.find(InstructorDetail.class,id);
        instructorDetail.getInstructor().setInstructorDetail(null);

        entityManager.remove(instructorDetail);
    }

    @Override
    public List<Course> findCourseByInstructorId(int id) {

        TypedQuery<Course> query=entityManager.createQuery("from Course where instructor.id= :data",Course.class);

        query.setParameter("data",id);

        List<Course> courses=query.getResultList();
        return  courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        TypedQuery<Instructor> query=entityManager.createQuery("select i from Instructor i "+"JOIN FETCH i.courses "+"JOIN FETCH i.instructorDetail "+"where i.id= :data", Instructor.class);

        query.setParameter("data",id);
        Instructor instructor=query.getSingleResult();
        return instructor;
    }

    @Override
    @Transactional
    public void update(Instructor tempInstructor) {
        entityManager.merge(tempInstructor);
    }

    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseById(int id) {
        return entityManager.find(Course.class,id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor tempInstructor=entityManager.find(Instructor.class,id);
        List<Course> courses=tempInstructor.getCourses();

        for(Course c:courses){
            c.setInstructor(null);
        }
        entityManager.remove(tempInstructor);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        Course course=entityManager.find(Course.class,id);
        entityManager.remove(course);
    }

}
