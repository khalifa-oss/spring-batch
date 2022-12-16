package com.tech.springbatchdemo.controller;

import com.tech.springbatchdemo.model.University;
import com.tech.springbatchdemo.repository.UniversityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/university")
public class UniversityController {
    private UniversityRepository universityRepository;
    static List<University> university= Arrays.asList( new University(1,"fsm",List.of(StudentController.students.get( 1 )))
            ,new University(1,"fsg",List.of(StudentController.students.get( 0 ),StudentController.students.get( 1 ))));

    public UniversityController(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;




    }
//    public  static List<University>createList(){
//
//        System.out.println(universities+"11111111111111111");
//
//
//     return universities ;
//    }

    @PostMapping("saveAll")
    public ResponseEntity<String> saveAll() {
        universityRepository.saveAll(university );
        return new ResponseEntity<>( "goood", HttpStatus.OK );
    }
    @GetMapping("getAll")
    List<University>getAll(){
        return universityRepository.findAll();
    }
    @GetMapping("get")
        public String get(){
            return "----------hello there----------";
        }
    }



