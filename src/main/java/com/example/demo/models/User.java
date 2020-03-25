package com.example.demo.models;

import com.example.demo.models.AuditModel;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class User extends AuditModel {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    @Column(unique = true)
    private String email;
}