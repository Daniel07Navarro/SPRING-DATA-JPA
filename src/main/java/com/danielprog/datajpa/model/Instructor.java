package com.danielprog.datajpa.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "instructor")
@Getter
@Setter
@NoArgsConstructor
public class Instructor {

    public Instructor(int id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator= "instructor_generator")
    @SequenceGenerator(name = "instructor_generator",allocationSize = 1)
    private int id;

    @Column(name = "nombre",nullable = false)
    private String nombre;

    @Column(name = "apellido",nullable = false)
    private String apellido;

    //Un solo instructor puede dar clases de muchos cursos
    @OneToMany(mappedBy = "instructor",cascade = CascadeType.ALL)
    private Set<Course> courses = new HashSet<>(); //almacena todos los cursos que va a impartir el instructor

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
