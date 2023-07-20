package com.edith.cruddemo.service;

import com.edith.cruddemo.dao.EmployeeDao;
import com.edith.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeServiceInterface{


    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImp(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeDao.findAllEmpoyee();
    }

    @Override
    public Employee findById(int id) {
        return this.employeeDao.findById(id);
    }
    @Transactional
    @Override
    public Employee save(Employee employee) {
        return this.employeeDao.save(employee);
    }
    @Transactional
    @Override
    public void deleteById(int id) {
        this.employeeDao.deleteById(id);
    }
}
