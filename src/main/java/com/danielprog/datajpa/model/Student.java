package com.danielprog.datajpa.model;


import com.danielprog.datajpa.model.embedded_id.StudentCourse;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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

    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn // para indicar que la llave primaria de student va a ser usada para los valores de la llave foranea contact into
    ContacInfo contacInfo;

    /*
    @ManyToMany
    @JoinTable(name = "student_course", //nombre de la tabla nueva
                joinColumns = @JoinColumn(name = "student_id"), //definimos el nombre de la columna que almacena la llave primaria de la entidad propietaria
                inverseJoinColumns = @JoinColumn(name = "course_id")) //se define lo mismo que en el join column solo que para la otra entidad
    private Set<Course> courses = new HashSet<>();
    */

    /*
    //ID CLASS
    @OneToMany(mappedBy = "student")
    private Set<StudentCourse> studentCourses = new HashSet<>();
    */


    //Embedded
    @OneToMany(mappedBy = "student")
    private Set<StudentCourse> courseStudent = new HashSet<>();

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
