package com.example.spring.bootsecurity.controller;

import com.example.spring.bootsecurity.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    List<Student> students = new ArrayList<>();
    @GetMapping("/students")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Student> getStudents(){
        Student s1 = new Student();
        s1.setFirstName("Mounika");
        s1.setId(1);
        s1.setLastName("Sika");

        Student s2 = new Student();
        s2.setFirstName("Harini");
        s2.setId(2);
        s2.setLastName("Sika");

        Student s3 = new Student();
        s3.setFirstName("Aiden");
        s3.setId(3);
        s3.setLastName("Motupally");
        students.add(s1);
        students.add(s2);
        students.add(s3);

        return students;
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/students")
    public ResponseEntity<Student> create(@RequestBody Student student){
        students.add(student);

        ResponseEntity<Student> responseEntity = new ResponseEntity<>(student, HttpStatus.CREATED);
        return responseEntity;
    }

    @PostMapping("/{id}")
    public void test(@PathVariable  long id){
        long a = id;
        System.out.println(a);
    }
}
