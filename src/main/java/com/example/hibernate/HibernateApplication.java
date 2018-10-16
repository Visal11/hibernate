package com.example.hibernate;

import com.example.hibernate.Repositories.StudentRepositories;
import com.example.hibernate.models.Student;
import com.example.hibernate.services.StudentService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan
public class HibernateApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(HibernateApplication.class, args);
    }

//    private StudentService studentService;
//
//    public HibernateApplication(StudentService studentService) {
//        this.studentService = studentService;
//    }
    private StudentRepositories studentRepositories;

    public HibernateApplication(StudentRepositories studentRepositories) {
        this.studentRepositories = studentRepositories;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Student student=new Student("Student Name","Male",21.5);
        Student student1=new Student("Student Name1","Female",22.5);
        Student student2=new Student("Student Name2", "Male", 23.5);

        this.studentRepositories.save(student);
        this.studentRepositories.save(student1);
        this.studentRepositories.save(student2);
        System.out.println("CountStudent="+this.studentRepositories.count());
//        this.studentService.save(student);
//        this.studentService.save(student1);
//
//        System.out.println(this.studentService.findOneStudent(10L));
//        System.out.println("========================================");
//        System.out.println(this.studentService.getAll());
    }
}
