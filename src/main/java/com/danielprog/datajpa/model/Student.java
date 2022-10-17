package com.danielprog.datajpa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "student")
@Getter
@Setter
public class Student {

    public Student(){

    }

    public Student(int id, String nombre, String apellido, LocalDate fechaCumpleaños) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaCumpleaños = fechaCumpleaños;
    }

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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaCumpleaños=" + fechaCumpleaños +
                '}';
    }
}
