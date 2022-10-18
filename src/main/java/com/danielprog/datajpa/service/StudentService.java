package com.danielprog.datajpa.service;

import com.danielprog.datajpa.model.Student;
import com.danielprog.datajpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    @Qualifier("studentRepository")
    StudentRepository studentRepository;

    public List<Student> listarEstudiantes(){
        return studentRepository.findAll();
    }

}
