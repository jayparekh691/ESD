package com.example.project3.service;

import com.example.project3.bean.Organization;
import com.example.project3.bean.Organization_HR;
import com.example.project3.dao.Organization_HRDAO;
import com.example.project3.dao.impl.Organization_HRDAOImpl;

import java.util.List;

public class Organization_HRServices {


    Organization_HRDAOImpl organization_hrdao = new Organization_HRDAOImpl();
    public List<Organization_HR> getOrganSer_HR(Integer org) {
        List<Organization_HR> organization_hrList = organization_hrdao.getOrganization_HR(org);
//        for(Organization_HR organization_hr : organization_hrList)
//           organization_hr.setOrganization_id(null);
        return organization_hrList;
    }
    public List<Organization_HR> getOrganSer_HR(){
        List<Organization_HR> organization_hrList = organization_hrdao.getOrganization_HR();
//        for(Organization_HR organization_hr : organization_hrList)
//            organization_hr.setOrganization_id(null);
        return organization_hrList;
    }
    public Boolean createorganization_hr(Organization_HR o){
        return organization_hrdao.createOrganization_HR(o);
    }

    public Boolean deleteorganSer_HR(Integer o){
        return organization_hrdao.deleteorganization_HR(o);
    }

    public void updateOrg_hr(Integer n,Organization_HR o){
        organization_hrdao.UpdateOrganization_HR(n,o);
    }
}