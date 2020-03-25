package com.example.demo;

import javax.persistence.*;

@Entity
public class Task {

    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //@Column(nullable = false)
    //private User user;
}
