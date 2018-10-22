package com.example.hibernate.controllers.restcontrollers;

import com.example.hibernate.models.Student;
import com.example.hibernate.services.impl.StudentServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class StudentRestController {
    private StudentServiceImpl studentServiceImpl;

    public StudentRestController(StudentServiceImpl studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
    }

    /*@PostMapping("")
    public Map<String,Object> save(@RequestBody Student student)
    {
       this.studentServiceImpl.save(student);
       Map<String,Object> response=new HashMap<>();
       response.put("status", true);
       response.put("student", student);
       response.put("message", "Insert Success.");
       return response;
    }*/

    @PostMapping("")
    public Map<String,Object> save(@RequestBody Student student)
    {
      this.studentServiceImpl.save(student);
      Map<String,Object> response=new HashMap<>();
      response.put("status", true);
      response.put("student",student);
      response.put("message","Insert Successfully.");
      return response;
    }

    @GetMapping("")
    public Map<String,Object> count()
    {
      Long a;
      a=this.studentServiceImpl.count();
      Map<String,Object> response=new HashMap<>();
      response.put("status", true);
      System.out.println("Count Student:"+a);
      response.put("message", "Count Successfully.");
      return response;
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> deleteById(@PathVariable("id") Long id)
    {
      this.studentServiceImpl.deleteById(id);
      Map<String, Object> response= new HashMap<>();
      response.put("status",true);
      response.put("message","Delete Sucessfully.");
      return response;
    }

    @PutMapping("")
    public Map<String, Object> update(@RequestBody Student student)
    {
      this.studentServiceImpl.update(student);
      Map<String, Object> response= new HashMap<>();
      response.put("status",true);
      response.put("message","Update Successfully.");
      return response;
    }

    @GetMapping("/{id}")
    public Map<String, Object> findOneStudent(@PathVariable("id") Long id)
    {
        Optional<Student> student=this.studentServiceImpl.findOneStudent(id);
        Map<String, Object> response= new HashMap<>();
        if(student!=null) {
            response.put("status", true);
            response.put("student", student);
            response.put("message", "Student data was access.");
        }else{
            response.put("status", false);
            response.put("student", null);
            response.put("message", "Student not found.");
        }
        return response;
    }

    /*@GetMapping("/{id}")
    public Map<String, Object> findOneStudent(@PathVariable("id") Long id)
    {
        Student student = this.studentServiceImpl.findOneStudent(id);
        Map<String, Object> response= new HashMap<>();
        if(student!=null) {
            response.put("status", true);
            response.put("student", student);
            response.put("message", "Student data was access.");
        }else{
            response.put("status", false);
            response.put("student", null);
            response.put("message", "Student not found.");
        }
        return response;
    }*/

    /*@GetMapping("/all")
    public Map<String, Object> getAll(@RequestBody Student student)
    {
      this.studentServiceImpl.getAll();
      Map<String, Object> response= new HashMap<>();
      response.put("status", true);
      response.put("student", student);
      response.put("message", "Show all student was access.");
      return response;
    }*/

    /*@DeleteMapping("/{id}")
    public Map<String, Object> deleteById(@PathVariable("id") Long id)
    {
       this.studentServiceImpl.deleteById(id);
       Map<String, Object> response= new HashMap<>();
       response.put("status", true);
       response.put("message", "Delete successfully");
       return response;
    }*/
}
