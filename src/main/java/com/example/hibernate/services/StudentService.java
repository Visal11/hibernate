package com.example.hibernate.services;

import com.example.hibernate.models.Student;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentService {

    @PersistenceContext
    private EntityManager entityManager;

    public StudentService() {
    }

    //function for save information of student
    public void save(Student student){
      entityManager.persist(student);
    }

    //function for findOneStudent information of student
    public Student findOneStudent(Long id){
      return entityManager.find(Student.class,id);
    }

    //function for getAll information of student
    public List<Student> getAll(){
     //Form1
     /*TypedQuery query= entityManager.createQuery("select se from Student_Entity se", Student.class);
     return query.getResultList();*/

     //Form2
       //Apply NamedQuery
       return entityManager.createNamedQuery("StudentGetAllNameQuery",Student.class).getResultList();
    }
}
