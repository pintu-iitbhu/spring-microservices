package com.edith.cruddemo.controller;

import com.edith.cruddemo.entity.Student;
import com.edith.cruddemo.errors.StudentErrorResponse;
import com.edith.cruddemo.exceptions.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoRestController {

    private List<Student> students;

    @PostConstruct
    void LoadData(){
        Student student1= new Student("pintu","Kumar", "yadav@gmail.com");
        student1.setId(1);
        Student student2= new Student("pintu2","Kumar2", "yadav2@gmail.com");
        student2.setId(2);
        Student student3= new Student("pintu","Kumar", "yadav@gmail.com");
        student3.setId(3);
        students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);

    }
    @GetMapping("/students")
    ResponseEntity<List<Student>> getAllStudents(){
        return new ResponseEntity<>(this.students,HttpStatus.OK);
    }
    @GetMapping("/students/{student}")
    ResponseEntity<Student> getStudentById(@PathVariable int student) throws StudentNotFoundException {

        if (student <0 || student >= this.students.size()){
            throw new StudentNotFoundException("Student Not found : " + student );
        }
        return new ResponseEntity<>(this.students.get(student), HttpStatus.OK);
    }
//
//    // Add Exception Handler for StudentNotFoundException
//    @ExceptionHandler
//    ResponseEntity<StudentErrorResponse> ExceptionHandler(StudentNotFoundException exc) {
//        StudentErrorResponse errorResponse = new StudentErrorResponse();
//        errorResponse.setMessage(exc.getMessage());
//        errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
//        errorResponse.setTimeStamp(System.currentTimeMillis());
//
//        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
//    }
//
//    //Add exception handler for any exceptions
//    @ExceptionHandler
//    ResponseEntity<StudentErrorResponse> Hnadler(Exception exc){
//        StudentErrorResponse errorResponse = new StudentErrorResponse();
//        errorResponse.setMessage(exc.getMessage());
//        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
//        errorResponse.setTimeStamp(System.currentTimeMillis());
//
//        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
//    }
}
