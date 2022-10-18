package com.danielprog.datajpa.model;


import com.danielprog.datajpa.model.embedded_id.StudentCourse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="course")
@NoArgsConstructor
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "course_generator")
    @SequenceGenerator(name = "course_generator",allocationSize = 1)
    private int id;

    @Column(name = "name",nullable = false)
    private String name;

    //RELACION DE CURSOS CON INSTRUCTOR
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER) //todos los datos deben ser obtenidos inmediatamente
    private Instructor instructor;

    /*
    //RELACION CURSOS ESTUDIANTE
    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();
    */

    /*
    //id class
    @OneToMany(mappedBy = "course",fetch = FetchType.EAGER)
    private Set<StudentCourse> studentCourses = new HashSet<>();
    */

    //EmbeddedId
    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private Set<StudentCourse> studentCourses = new HashSet<>();

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
