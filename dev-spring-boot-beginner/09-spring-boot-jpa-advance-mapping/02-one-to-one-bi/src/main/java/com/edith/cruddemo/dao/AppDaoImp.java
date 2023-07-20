package com.edith.cruddemo.dao;

import com.edith.cruddemo.entity.Instructor;
import com.edith.cruddemo.entity.InstructorDetails;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
