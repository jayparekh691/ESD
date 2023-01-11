package com.example.project3.util;

import com.example.project3.bean.Employee;
import com.example.project3.bean.Organization;
import com.example.project3.bean.Organization_HR;
import com.example.project3.dao.EmployeeDAO;
import com.example.project3.dao.Organization_HRDAO;
import com.example.project3.dao.impl.EmployeeDAOImpl;
import com.example.project3.dao.impl.OrganizationDAOImpl;
import com.example.project3.dao.impl.Organization_HRDAOImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class InitializeDB {
    public static void main(String args[]){
        List<List<Object>> organ = Arrays.asList(
                Arrays.asList("Microsoft", "Electronic City phase 1"),
                Arrays.asList("Google", "Kormangla"),
                Arrays.asList("Meta", "Hydebrad")
        );
        List<List<Object>> emp = Arrays.asList(
                Arrays.asList("Jay", "Parekh", "jay.parekh@iiitb.ac.in", "Manager","1234","xyz",5),
                Arrays.asList("Monit", "Thakkar", "monit.thakkar@iiitb.ac.in","Associate","1234","zxy",5),
                Arrays.asList("Ashutosh", "Soni", "ashutosh.soni@iiitb.ac.in","CEO","1234","dkk",10)
        );
        List<List<Object>> organization_hr = Arrays.asList(
                Arrays.asList("Jayant", "Mukundam", "jayant.mukundum@iiitb.ac.in","841313284"),
                Arrays.asList("Gaurav", "Tilokani", "gaurav.tilokani@iiitb.ac.in","832135584"),

                Arrays.asList("Jay", "Parekh", "jay.parekh@iiitb.ac.in","841313284"),
                Arrays.asList("kahbfkaj", "askdjbfk", "dfskbfd.gsdkg@iiitb.ac.in","832135584"),

                Arrays.asList("Tushar", "Nagpal", "tushar.nagpal@iiitb.ac.in","816521384"),
                Arrays.asList("Nishit", "Chechani", "nishit.chechani@iiitb.ac.in","842213284")
        );
        OrganizationDAOImpl organizationDAO = new OrganizationDAOImpl();
        Organization_HRDAO organization_hrdao = new Organization_HRDAOImpl();
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        for(List<Object> e : emp){
            Employee n = new Employee((String) e.get(0),(String) e.get(1),(String) e.get(2),(String) e.get(3),(String) e.get(4),(String) e.get(5),(Integer) e.get(6));
            employeeDAO.createEmployee(n);
        }

//        for(List<Object> o : organ){
//            Organization n = new Organization((String) o.get(0),(String) o.get(1));
//            organizationDAO.createOrganization(n);
//        }
        List<Organization_HR> organization_hrList = new ArrayList<>();

        for(List<Object> l : organization_hr){
            Organization_HR organization1 = new Organization_HR((String) l.get(0),(String) l.get(1),(String) l.get(2),(String) l.get(3));
            organization_hrList.add(organization1);
        }
        int j=0;
        for(int i=0;i<organ.size();i++){
            List<Object> org = organ.get(i);
            Organization orgobj = new Organization((String) org.get(0),(String) org.get(1));
            organization_hrList.get(j).setOrganization_id(orgobj);
            organization_hrList.get(j+1).setOrganization_id(orgobj);

            orgobj.setOrganization_hrList(Arrays.asList(organization_hrList.get(j),organization_hrList.get(j+1)));

            organizationDAO.createOrganization(orgobj);

            organization_hrdao.createOrganization_HR(organization_hrList.get(j));
            organization_hrdao.createOrganization_HR(organization_hrList.get(j+1));
            j+=2;
        }
    }
}
