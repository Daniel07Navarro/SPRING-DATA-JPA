package com.danielprog.datajpa.model.embedded_id;


import com.danielprog.datajpa.model.Course;
import com.danielprog.datajpa.model.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class StudentCourse {

    @EmbeddedId //define la llave primaria como compuesta
    private StudenCourseKey id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "student_id")
    @MapsId("studentId")
    private Student student;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "course_id")
    @MapsId("courseId")
    private Course course;

    @Column(name = "rating")
    private int rating;

    @Override
    public String toString() {
        return "StudentCourse{" +
                "id=" + id +
                ", student=" + student +
                ", course=" + course +
                ", rating=" + rating +
                '}';
    }
}

