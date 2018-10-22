package com.example.hibernate.services.impl;

import com.example.hibernate.Repositories.StudentRepositories;
import com.example.hibernate.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class StudentServiceImpl{

    @Autowired
    private StudentRepositories studentRepositories;

    @PersistenceContext
    private EntityManager entityManager;

    public StudentServiceImpl() {
    }

    //function for save information of student
    /*public void save(Student student){
      entityManager.persist(student);
    }*/

    public void save(Student student)
    {
      studentRepositories.save(student);
    }

    public Long count()
    {
      return studentRepositories.count();
    }

    public void deleteById(Long id)
    {
      studentRepositories.deleteById(id);
    }

    public void update(Student student)
    {
      studentRepositories.save(student);
    }

    public Optional<Student> findOneStudent(Long id)
    {
      return studentRepositories.findById(id);
    }



    //function for findOneStudent information of student
    /*public Student findOneStudent(Long id){
      return entityManager.find(Student.class,id);
    }*/

    /*public void deleteById(Long id){
      entityManager.remove(id);
    }*/

    //function for getAll information of student
    /*public List<Student> getAll(){
     //Form1
     /*TypedQuery query= entityManager.createQuery("select se from Student_Entity se", Student.class);
     return query.getResultList();*/

     //Form2
     //Apply NamedQuery
     //return entityManager.createNamedQuery("StudentGetAllNameQuery",Student.class).getResultList();
    //}

}
