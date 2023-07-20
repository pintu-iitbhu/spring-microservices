package com.edith.cruddemo.dao;

import com.edith.cruddemo.entity.Course;
import com.edith.cruddemo.entity.Instructor;
import com.edith.cruddemo.entity.InstructorDetails;

import java.util.List;

public interface AppDao {

    void save(Instructor instructor);
    Instructor findById(int id);

    void deleteInstructorById(int id);

    InstructorDetails findInstructorDetailsById(int id);

    List<Course> getCoursesByIntructorId(int theId);

    Instructor findIntructorByIdJoinFetch(int theId);
}
