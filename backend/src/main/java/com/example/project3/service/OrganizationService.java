package com.example.project3.service;

import com.example.project3.bean.Organization;
import com.example.project3.bean.Organization_HR;
import com.example.project3.dao.impl.OrganizationDAOImpl;
//import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

public class OrganizationService {

    OrganizationDAOImpl OrganizationDAO = new OrganizationDAOImpl();
    public List<Organization> getOrganizationN(Organization n){
        List<Organization> organizationList = OrganizationDAO.getOrganizationN(n);
//        for(Organization organization : organizationList)
//            organization.setOrganization_hrList(null);
        return organizationList;
    }

    public Boolean createorganization(Organization o){
        return OrganizationDAO.createOrganization(o);
    }
    public void deleteorganization(Organization n){
        OrganizationDAO.deleteorganization(n);
        return;

    }

    public List<Organization> getOrganization(){
        List<Organization> organizationList =OrganizationDAO.getOrganization();
//        for(Organization organization : organizationList)
//            organization.setOrganization_hrList(null);
        return organizationList;
    }
    public void updateOrg(Organization o){
        OrganizationDAO.UpdateOrganization(o);
    }

}
