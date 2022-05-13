package com.java.demo.rest;

import com.java.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
        return students.get(studentId);
    }
}
