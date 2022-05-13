package com.java.demo.rest;

import com.java.demo.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> students=new ArrayList<>();

    @PostConstruct
    public void loadStudents(){
        students=new ArrayList<>();

        students.add(new Student("ibrahim","kilic"));
        students.add(new Student("Laz","Ziya"));
        students.add(new Student("Mehmet","Karahanli"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        if(studentId >= students.size() || studentId<0){
            throw new StudentNotFoundException("Student not found please enter invalid id!");
        }

        return students.get(studentId);
    }

    /*
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> exceptionHandler(StudentNotFoundException e){
        StudentErrorResponse response=new StudentErrorResponse();

        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setMessage(e.getMessage());
        response.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> differentExc(Exception e){
        StudentErrorResponse response=new StudentErrorResponse();

        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setMessage(e.getMessage());
        response.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
    */
}
