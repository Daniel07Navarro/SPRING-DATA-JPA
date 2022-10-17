package com.danielprog.datajpa.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_generator")
    @SequenceGenerator(name = "student_generator",allocationSize = 1)
    private int id;

    @Column(name = "nombre",nullable = false) //por defecto el tamaño es 255 y con nullable verificamos si acepta o no elementos nulos
    private String nombre;

    @Column(name = "apellido",nullable = false)
    private String apellido;

    @Column(name = "fechaCumpleaños",nullable = false)
    private LocalDate fechaCumpleaños;


}
