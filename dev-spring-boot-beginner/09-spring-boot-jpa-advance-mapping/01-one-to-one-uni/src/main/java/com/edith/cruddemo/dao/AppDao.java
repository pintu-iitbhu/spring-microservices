package com.edith.cruddemo.dao;

import com.edith.cruddemo.entity.Instructor;

public interface AppDao {

    void save(Instructor instructor);
    Instructor findById(int id);

    void deleteInstructorById(int id);
}
