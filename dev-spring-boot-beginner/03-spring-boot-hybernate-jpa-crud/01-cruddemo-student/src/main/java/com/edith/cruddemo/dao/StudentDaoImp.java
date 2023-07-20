package com.edith.cruddemo.dao;

import com.edith.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class StudentDaoImp implements StudentDao{

    private EntityManager entityManager;
    @Autowired
    StudentDaoImp(EntityManager entityManager){
        this.entityManager= entityManager;
    }

    @Override
    @Transactional
    public void Save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student FindById(int id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> list = entityManager.createQuery("From Student", Student.class);
        return list.getResultList();
    }
}
