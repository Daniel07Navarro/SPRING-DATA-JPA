package com.danielprog.datajpa.repository;

import com.danielprog.datajpa.dto.CourseDTO;
import com.danielprog.datajpa.model.Course;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Qualifier("courseRepository")
public interface CourseRepository extends JpaRepository <Course,Integer>{

    List<CourseDTO> findByInstructor_Id(int id);

}
