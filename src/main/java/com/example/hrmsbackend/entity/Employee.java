package com.example.hrmsbackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String department;
    private int experience;
    private int satisfaction;

    public Employee() {}

    public Employee(
            String name,
            String department,
            int experience,
            int satisfaction) {
        this.name = name;
        this.department = department;
        this.experience = experience;
        this.satisfaction = satisfaction;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public int getExperience() { return experience; }
    public int getSatisfaction() { return satisfaction; }

    public void setName(String name) { this.name = name; }
    public void setDepartment(String department) {
        this.department = department;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }
    public void setSatisfaction(int satisfaction) {
        this.satisfaction = satisfaction;
    }
}
