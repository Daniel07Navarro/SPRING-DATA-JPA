package com.danielprog.datajpa.controller;


import com.danielprog.datajpa.model.Student;
import com.danielprog.datajpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "estudiantesJpa")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Student> listarEstudiantes(){
        return  studentService.listarEstudiantes();
    }

}
