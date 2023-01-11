package com.example.project3.bean;

import jakarta.persistence.*;
@Entity
@Table
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employee_id;

    @Column(nullable = false)
    private String first_name;

    @Column
    private String last_name;

    @Column(nullable = false,unique = true)
    private String email;

    @Column
    private String title;

    @Column
    private String password;

    @Column
    private String photograph_path;

    @Column
    private Integer department;

    public Employee(){}

    public Employee(String first_name,String last_name,String email,String title,String password,String photograph_path,Integer department){
        this.first_name=first_name;
        this.last_name=last_name;
        this.email=email;
        this.password=password;
        this.title=title;
        this.photograph_path=photograph_path;
        this.department=department;
    }
    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public Integer getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPhotograph_path() {
        return photograph_path;
    }

    public String getTitle() {
        return title;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setPhotograph_path(String photograph_path) {
        this.photograph_path = photograph_path;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
