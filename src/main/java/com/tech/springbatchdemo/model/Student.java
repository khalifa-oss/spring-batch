package com.tech.springbatchdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
   private String name ;
   @ManyToOne(fetch =FetchType.EAGER)
   @JoinColumn(name = "university_id",insertable = false)
   private University university;

}
