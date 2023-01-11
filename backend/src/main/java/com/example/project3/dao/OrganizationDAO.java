package com.example.project3.dao;

import com.example.project3.bean.Organization;
//import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;


public interface OrganizationDAO {


    void deleteorganization(Organization n);
    List<Organization> getOrganization();
    List<Organization> getOrganizationN(Organization n);
    Boolean createOrganization(Organization registry);

    void UpdateOrganization(Organization o);


}
