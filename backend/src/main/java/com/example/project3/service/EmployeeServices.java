package com.example.project3.service;

import com.example.project3.bean.Employee;
import com.example.project3.dao.impl.EmployeeDAOImpl;

public class EmployeeServices {
    EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();

    public Employee login(Employee employee){
        Employee loggedInEmployee = employeeDAO.login(employee);

        return loggedInEmployee;
    }
}
