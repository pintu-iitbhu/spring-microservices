package com.edith.cruddemo.dao;

import com.edith.cruddemo.entity.Instructor;
import com.edith.cruddemo.entity.InstructorDetails;

public interface AppDao {

    void save(Instructor instructor);
    Instructor findById(int id);

    void deleteInstructorById(int id);

    InstructorDetails findInstructorDetailsById(int id);
}
