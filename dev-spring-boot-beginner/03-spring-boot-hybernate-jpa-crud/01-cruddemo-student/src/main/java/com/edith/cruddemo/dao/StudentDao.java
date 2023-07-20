package com.edith.cruddemo.dao;

import com.edith.cruddemo.entity.Student;

import java.util.List;

public interface StudentDao {
    public void Save(Student student);

    public Student FindById(int id);

    public List<Student> findAll();
}
