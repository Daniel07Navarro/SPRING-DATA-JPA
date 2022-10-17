package com.danielprog.datajpa.utils;

import com.danielprog.datajpa.model.Student;
import com.danielprog.datajpa.repository.CourseRepository;
import com.danielprog.datajpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Set;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
   private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        //SAVE AND SAVE ALL
        //Student estudiante1 = new Student("Daniel","Navarro", LocalDate.of(2002,2,7));
        //Student estudiante2 = new Student("Pedro","Juarez", LocalDate.of(2002,4,6));
        //UTILIZANDO UN SAVE ALL
        //studentRepository.saveAll(Set.of(estudiante1,estudiante2));


        //USANDO LAS CONSULTAS PERSONALIZADAS (QUERY)
        //USANDO @Query
        studentRepository.findByFirstName("Leora").forEach(System.out::println);
        studentRepository.findByFirstNameLike("ri").forEach(System.out::println);

        //studentRepository.findByNameNative("Dari").forEach(System.out::println);
        //studentRepository.findByNameApellido("Leora","Tutill").forEach(System.out::println);

        //Update
        //studentRepository.updateFirstNameById(6,"Juancho");
        //studentRepository.findAll().forEach(System.out::println);

        /*
        //Usando el metodo nombrado
        studentRepository.findByBirthDateGreaterThan(LocalDate.of(1985,1,1)).forEach(System.out::println);
        if(studentRepository.existsByFirstName("Leora")){
            System.out.println("Leora existe");
        }
        System.out.println("Count: "+studentRepository.count());
        System.out.println("Count: "+studentRepository.countByFirstName("Leora"));
        studentRepository.deleteByFirstName("Leora");
        System.out.println("Count: "+studentRepository.count());
        */

        //Multiple Tables
        //studentRepository.findByContactInfo_StateIgnoreCase("michigan").forEach(System.out::println);
        //studentRepository.findByContactInfo_StateIgnoreCaseOrderByFirstNameAscLastNameDesc("michigan").forEach(System.out::println);
        //studentRepository.findByContactInfo_StateOrContactInfo_StateAllIgnoreCase("Michigan","ohio");

        //Sorting consulta de todos los estudiantes en forma ascendente
        //studentRepository.findAll(Sort.by(Sort.Direction.ASC, "firstName")).forEach(System.out::println);

        /*
        //PAGINACION
        //page: cantidad de paginas, size: la cantidad de registros en cada pagina y por ultimo el orden
        System.out.println("Pagina 1");
        Pageable pageable = PageRequest.of(0,6,Sort.by(Sort.Direction.DESC,"birthDate"));
        studentRepository.findAll(pageable).forEach(System.out::println);

        System.out.println("Pagina 2");
        pageable = PageRequest.of(1,6,Sort.by(Sort.Direction.DESC,"birthDate"));
        studentRepository.findAll(pageable).forEach(System.out::println);

        pageable = Pageable.unpaged();
        */

        var result = courseRepository.findByInstructor_Id(1);
        System.out.println(result);
        for (var course:result){
            System.out.println(course.getName()+ " -> Instructor" +course.getInstructorName()+ " -> Students "+ course.getStudentCount());
        }
    }

}
