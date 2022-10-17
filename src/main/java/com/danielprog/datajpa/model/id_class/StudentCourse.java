/*
package com.danielprog.datajpa.model.id_class;

import com.danielprog.datajpa.model.Course;
import com.danielprog.datajpa.model.Student;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
*/

/*
@Entity
@Getter
@Setter
@IdClass(StudentCourseKey.class) //definimos la llave de la entidad
public class StudentCourse {

    //VA A TENER DOS LLAVES PRIMARIAS
    @Id
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Student student;

    @Id
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Course course;

    @Column(name = "rating")
    private int rating;
}
*/

