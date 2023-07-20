package com.edith.cruddemo.dao;

import com.edith.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAllEmpoyee();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);
}
