package com.edith.cruddemo.service;

import com.edith.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeServiceInterface {

    List<Employee> findAllEmployees();
    Employee findById(int id);
    Employee save(Employee employee);

    void deleteById(int id);
}
