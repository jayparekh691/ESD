package com.example.project3.dao.impl;

import com.example.project3.util.HibernateSessionUtil;
import com.example.project3.bean.Employee;
import com.example.project3.dao.EmployeeDAO;
//import com.sun.org.apache.xpath.internal.operations.Bool;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public Employee login(Employee employee){
        try (Session session=HibernateSessionUtil.getSession();){
            String employeeemail= employee.getEmail();
            String employeepassword=employee.getPassword();

            List<Object> result = new ArrayList<>(session.createQuery("FROM Employee WHERE email= :employeeemail and password = :employeepassword and department=5")
                    .setParameter("employeeemail",employeeemail)
                    .setParameter("employeepassword",employeepassword)
                    .list()
                    );

                if(result.size()==0)
                    return null;
                else
                    return (Employee) result.get(0);
        }
        catch (HibernateException exception){
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }
    @Override
    public void createEmployee(Employee e){
        try (Session session=HibernateSessionUtil.getSession()){
            Transaction transaction=session.beginTransaction();
            session.save(e);
            transaction.commit();
        }
        catch (HibernateException exception){
            System.out.print(exception.getLocalizedMessage());
        }
    }
}
