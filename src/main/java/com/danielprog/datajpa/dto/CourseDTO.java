package com.danielprog.datajpa.dto;

import org.springframework.beans.factory.annotation.Value;

public interface CourseDTO {

    int getId();
    String getName();

    @Value("#{target.instructor.getFirstName()}")
    String getInstructorName();

    @Value("#{target.studentCourses.size()}")
    int getStudentCount();
}
