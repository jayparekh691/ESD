package com.example.project3.bean;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import jakarta.ws.rs.DELETE;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;
@Entity
@Table
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer o_id;

    @Column(nullable = false)
    private String name;

    @Column
    private String address;
    @OneToMany(mappedBy = "org", fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Organization_HR> organization_hrList;

    public Organization(){}

    public Organization(String name, String address){
        this.name=name;
        this.address=address;
    }

    public void setO_id(Integer o_id) {
        this.o_id = o_id;
    }

    public Integer getO_id() {
        return o_id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrganization_hrList(List<Organization_HR> organization_hrList) {
        this.organization_hrList = organization_hrList;
    }

    public List<Organization_HR> getOrganization_hrList() {
        return organization_hrList;
    }

}
