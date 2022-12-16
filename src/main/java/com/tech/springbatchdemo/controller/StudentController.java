package com.tech.springbatchdemo.controller;

import com.tech.springbatchdemo.model.Student;
import com.tech.springbatchdemo.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpClient;
import java.util.List;
import java.util.Optional;
//Allow the cors for the request of  the origin "http:localhost:8081" only with the request method get and delete
//@CrossOrigin(origins = "http:localhost:8081",methods={RequestMethod.DELETE,RequestMethod.GET})
@RestController
@RequestMapping("student")
public class StudentController {
   static List<Student> students= List.of(new Student(1,"khalifa"),new Student(2,"ridha"),new Student(3,"sayeb"));

    private StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    //allow the cors to the request of the origin "http:localhost:8081" to the get methods only
    //@CrossOrigin(origins = "http:localhost:8081")
    @GetMapping("/{id}/{name}")
    public Student addStudent(@PathVariable(value = "id") int id, @PathVariable(value = "name") String name) {
        studentRepository.save( new Student( id, name ) );
        return new Student( id, name );

    }

    @PostMapping("/save")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {

        studentRepository.save( student );
//        return new  ResponseEntity<>(student,HttpStatus.OK  );
        return ResponseEntity.status( HttpStatus.OK ).body( student );
    }

    @PostMapping("/saveAll")
    public ResponseEntity<String> addAllStudent() {

        studentRepository.saveAll( students );
        return new ResponseEntity<>(  "it is ok ",HttpStatus.OK);
    }
}
