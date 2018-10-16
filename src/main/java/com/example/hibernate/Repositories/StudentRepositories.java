package com.example.hibernate.Repositories;

import com.example.hibernate.models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositories extends CrudRepository<Student,Long> {

}
