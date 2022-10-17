package com.danielprog.datajpa.model;

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

    @Column(name = "nombre",nullable = false)
    private String nombre;

    @ManyToOne(fetch = FetchType.EAGER) //todos los datos deben ser obtenidos inmediatamente
    private Instructor instructor;

    //AGREGAMOS UNA COLECCION
    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
