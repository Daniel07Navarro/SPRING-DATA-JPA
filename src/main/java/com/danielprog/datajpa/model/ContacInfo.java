package com.danielprog.datajpa.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "contac_info")
public class ContacInfo {

    public ContacInfo(int id, String email, String numero, String direccion, String ciudad, String estado, String zip, Student student) {
        this.id = id;
        this.email = email;
        this.numero = numero;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.estado = estado;
        this.zip = zip;
        this.student = student;
    }

    @Id
    @Column(name = "student_id") //para identicar que tendra los valores de los id de los estudiantes
    private int id;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "numero",nullable = false)
    private String numero;

    @Column(name = "direccion",nullable = false)
    private String direccion;

    @Column(name = "ciudad",nullable = false)
    private String ciudad;

    @Column(name = "estado",nullable = false)
    private String estado;

    @Column(name = "zip",nullable = false)
    private String zip;

    @OneToOne(cascade = CascadeType.ALL,optional = false)
    @MapsId //Para indicar que los valores seran copiados de la llave primaria de student
    @JoinColumn(name = "student_id") //nombre de la llave foranea
    private Student student; //Apunta a la entidad estudiantes

    @Override
    public String toString() {
        return "ContacInfo{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", numero='" + numero + '\'' +
                ", direccion='" + direccion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", estado='" + estado + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
