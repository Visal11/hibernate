package com.example.hibernate;

import com.example.hibernate.models.Student;
import com.example.hibernate.services.StudentService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(HibernateApplication.class, args);
    }

    private StudentService studentService;

    public HibernateApplication(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Student student=new Student("Student Name","Male",21.5);
        Student student1=new Student("Student Name1","Female",22.5);
        this.studentService.save(student);
        this.studentService.save(student1);

        System.out.println(this.studentService.findOneStudent(10L));
        System.out.println("========================================");
        System.out.println(this.studentService.getAll());
    }
}
