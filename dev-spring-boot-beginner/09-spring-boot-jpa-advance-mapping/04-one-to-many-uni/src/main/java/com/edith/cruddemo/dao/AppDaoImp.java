package com.edith.cruddemo.dao;

import com.edith.cruddemo.entity.Course;
import com.edith.cruddemo.entity.Instructor;
import com.edith.cruddemo.entity.InstructorDetails;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDaoImp implements AppDao{

    private EntityManager entityManager;
    @Autowired
    AppDaoImp(EntityManager entityManager){
        this.entityManager= entityManager;
    }
    @Override
    @Transactional
    public void save(Instructor instructor) {
        this.entityManager.persist(instructor);
    }

    public Instructor findById(int id){
        Instructor instructor=this.entityManager.find(Instructor.class, id);
        return instructor;
    }

    @Override
    public void deleteInstructorById(int id) {
        this.entityManager.remove(id);
    }

    @Override
    public InstructorDetails findInstructorDetailsById(int id) {
        return this.entityManager.find(InstructorDetails.class, id);
    }

    @Override
    public List<Course> getCoursesByIntructorId(int theId) {

        TypedQuery<Course> query = this.entityManager.createQuery("from Course where instructor.id = :data", Course.class);
        query.setParameter("data", theId);

        List<Course> courses = query.getResultList();
        return courses;
    }

    @Override
    public Instructor findIntructorByIdJoinFetch(int theId) {

        TypedQuery<Instructor> query = this.entityManager.createQuery(
                        "select i from Instructor i " +
                        "JOIN FETCH i.courses " +
                                "JOIN FETCH i.instructorDetails "+
                        "where i.id = :data",Instructor.class);
        query.setParameter("data", theId);

        return query.getSingleResult();
    }
}
