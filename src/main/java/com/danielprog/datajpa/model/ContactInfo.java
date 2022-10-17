package com.danielprog.datajpa.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "contact_info")
public class ContactInfo {


    public ContactInfo(String email, String phone, String address, String city, String state, String zip, Student student) {
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.student = student;
    }

    //Esto hace que compartan una llave primaria
    @Id
    @Column(name = "student_id") //para identicar que tendra los valores de los id de los estudiantes
    private int id;

    //COLUMNAS DE LA ENTIDAD

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "phone",nullable = false)
    private String phone;

    @Column(name = "address",nullable = false)
    private String address;

    @Column(name = "city",nullable = false)
    private String city;

    @Column(name = "state",nullable = false)
    private String state;

    @Column(name = "zip",nullable = false)
    private String zip;

    @OneToOne(cascade = CascadeType.ALL,optional = false)
    @MapsId //Para indicar que los valores seran copiados de la llave primaria de student
    @JoinColumn(name = "student_id") //nombre de la llave foranea
    private Student student; //Apunta a la entidad estudiantes


    /* PRIMERA FORMA MEDIANTE UNA LLAVE FORANEA CREADA EN LA TABLA contact_info
    @OneToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "student_id") //Para especificar la columna que va a tener la relacion entre las dos entidades
    private Student student;
    */

    @Override
    public String toString() {
        return "ContacInfo{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", student=" + student +
                '}';
    }
}
