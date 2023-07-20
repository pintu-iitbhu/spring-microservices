package com.edith.cruddemo.rest;

import com.edith.cruddemo.entity.Employee;
import com.edith.cruddemo.service.EmployeeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeServiceImp employeeServiceImp;
    @Autowired
    public EmployeeRestController(EmployeeServiceImp employeeServiceImp) {
        this.employeeServiceImp = employeeServiceImp;
    }

    @GetMapping("employees")
    ResponseEntity<List<Employee>> getAllEmployees(){

        List<Employee> employees = this.employeeServiceImp.findAllEmployees();

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }


}
