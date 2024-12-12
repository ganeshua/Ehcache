package com.ganesh.Ehcache.controller;

import com.ganesh.Ehcache.config.CacheService;
import com.ganesh.Ehcache.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Qualifier("StudentCacheBean")
    @Autowired
    CacheService<Student, Student> cacheService;

    @GetMapping("/")
    public String welcome() {
        return "EhCache Service is Up and Running";
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {
        Student studentReq = new Student(id);

        Student studentCacheResult = cacheService.get(studentReq);

        if (studentCacheResult != null) {
            System.out.println(" Same Request Response collected from Cache");
            return studentCacheResult;
        } else {
            System.out.println(" No Cache aviable for this request.");
            Student newStudent = new Student();
            newStudent.setId(id);
            newStudent.setName("Java");
            newStudent.getAddress("Pune");
            newStudent.setCountry("India");
            newStudent.setSchool(" Pune School");

            // put into cachce
            cacheService.put(studentReq, newStudent);
            return newStudent;

        }

    }
}
