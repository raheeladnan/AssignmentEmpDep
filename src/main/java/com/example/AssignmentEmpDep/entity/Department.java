package com.example.AssignmentEmpDep.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepName() {
        return name;
    }

    public void setDepName(String depName) {
        this.name = depName;
    }
}
