package com.example.project3.dao;

import com.example.project3.bean.Organization_HR;

import java.util.List;


public interface Organization_HRDAO {
    List<Organization_HR> getOrganization_HR(Integer o);
    Boolean deleteorganization_HR(Integer o);

    List<Organization_HR> getOrganization_HR();
    Boolean createOrganization_HR(Organization_HR regist);

    void UpdateOrganization_HR(Integer n,Organization_HR o);
}
