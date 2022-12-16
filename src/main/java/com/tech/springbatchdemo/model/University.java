package com.tech.springbatchdemo.model;

import com.tech.springbatchdemo.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class University implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;
   private String name;

   @OneToMany(fetch = FetchType.LAZY)
   private List<Student> studentList;

    public University( String fsm) {
        this.name=fsm;
    }
}
