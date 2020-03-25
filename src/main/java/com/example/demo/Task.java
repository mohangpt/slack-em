package com.example.demo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Task {

    private String description;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;


}
