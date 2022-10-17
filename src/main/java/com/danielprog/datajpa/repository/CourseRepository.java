package com.danielprog.datajpa.repository;

import com.danielprog.datajpa.dto.CourseDTO;
import com.danielprog.datajpa.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository <Course,Integer>{

    List<CourseDTO> findByInstructor_Id(int id);

}
