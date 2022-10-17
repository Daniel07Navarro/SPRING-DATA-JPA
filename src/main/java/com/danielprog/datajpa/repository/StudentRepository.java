package com.danielprog.datajpa.repository;

import com.danielprog.datajpa.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    //POR DEFECTO TOMA LOS PARAMETROS EN EL ORDEN EN QUE SE PRESENTAN


    //JPQL QUERY consulta especifica
    @Query("select s from Student s where s.firstName = ?1")
    List<Student> findByFirstName(String firstName);

    @Query("select s from Student s where s.firstName like %?1%")
    List<Student> findByFirstNameLike(String firstName);


    //NATIVE SQL QUERY, cuando se usa native SQL no se puede usar el framework para el ordenamiento automatica para la paginacion
    @Query(value = "select * from student where first_name = ?1", nativeQuery = true)
    List<Student> findByFirstNameNative(String firstName);

    //JPAQ Named Parameters
    //Lo que se va a hacer ahora es hacer las consultas pero recibiendo el nombre del parametro directamente
    @Query("select s from Student s where s.firstName = :firstName and s.lastName = :lastName")
    List<Student> findByFirstNameLastNameNamed(@Param("firstName") String firstName, @Param("lastName") String lastName);


    //Para hacer actualizacion de entidades
    @Modifying //para realizar modificaciones
    @Query("update Student s set s.firstName = :firstName where s.id = :id")
    void updateFirstNameById(@Param("id") int id, @Param("firstName") String firstName);


    //Nombrando nombre de consultas (el framwork genera la consulta con el nombre del metodo)
    List<Student> findByBirthDateGreaterThan(LocalDate birthdate);
    List<Student> readByBirthDateGreaterThan(LocalDate birthdate);
    List<Student> getByBirthDateGreaterThan(LocalDate birthdate);
    List<Student> queryByBirthDateGreaterThan(LocalDate birthdate);
    List<Student> searchByBirthDateGreaterThan(LocalDate birthdate);
    List<Student> streamByBirthDateGreaterThan(LocalDate birthdate);

    //Para saber si una entidad existe en la base de datos
    boolean existsByFirstName(String firstName);
    int countByFirstName(String firstName); //cuenta los usuarios con ese registro

    void deleteByFirstName(String firstName);
    void removeByFirstName(String firstName);

    //Multiples tables
    List<Student> findByContactInfo_StateIgnoreCase(String state);
    List<Student> findByContactInfo_StateIgnoreCaseOrderByFirstNameAscLastNameDesc(String state);

    List<Student> findByContactInfo_StateIgnoreCaseOrderByIdDesc(String state);

    List<Student> findByContactInfo_StateOrContactInfo_StateAllIgnoreCase(String state1, String state2);

    //Native query pagin
    @Query(value = "select * from student where first_name = ?1",
            countQuery = "select count(*) from student where first_name = ?1", nativeQuery = true)
    Page<Student> findByFirstNameNativePaging(String firstName, Pageable pageable);
}
