package com.example.project3.controller;

import com.example.project3.bean.Employee;
import com.example.project3.service.EmployeeServices;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/employee")
public class EmployeeController {
    EmployeeServices employeeServices = new EmployeeServices();

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(Employee employee){
        Employee loggedInEmployee = employeeServices.login(employee);
        System.out.print("Hello");
        if(loggedInEmployee == null)
            return Response.status(400).build();
        else {
            System.out.print("Login Successful");
            return Response.ok(202).build();
        }
    }
}
