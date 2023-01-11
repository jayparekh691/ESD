package com.example.project3.bean;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;

@Entity
@Table
public class Organization_HR {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hr_id;

    @Column(nullable = false)
    private String first_name;

    @Column
    private String last_name;

    @Column(unique = true)
    private String email;

    @Column
    private String contact_number;

    @ManyToOne
    @JoinColumn(name = "oid",nullable=false)
    @JsonbTransient
    private Organization org;

    public Organization_HR(){

    }

    public Organization_HR(String first_name, String last_name, String email,String contact_number){
        this.first_name=first_name;
        this.last_name=last_name;
        this.email=email;
        this.contact_number=contact_number;
    }

    public Integer geto_id() {
        return this.org.getO_id();
    }

    public Organization getOrg(){ return org;}
    public Integer getHr_id() {
        return hr_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name(){return last_name;}

    public String getEmail(){return email; }

    public String getContact_number(){return contact_number;}

//    public Organization getOrganization_id(){ return organization_id;}

    public void setId(Integer id){ this.hr_id=id;}

    public void setFirst_name(String first_name){ this.first_name= first_name;}

    public void setLast_name(String last_name){this.last_name=last_name;}

    public void setemail(String email){this.email=email;}

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public void setOrganization_id(Organization o) {
        this.org=o;
    }
    public void setOrgid(Integer i){this.org.setO_id(i);}

}

