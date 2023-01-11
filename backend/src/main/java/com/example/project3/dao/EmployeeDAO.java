package com.example.project3.dao;

import com.example.project3.bean.Employee;

public interface EmployeeDAO {

    Employee login(Employee employee);

    void createEmployee(Employee e);
}
