package com.example.project3.controller;

import java.lang.instrument.Instrumentation;
import com.example.project3.bean.Organization;
import com.example.project3.bean.Organization_HR;
import com.example.project3.dao.impl.OrganizationDAOImpl;
import com.example.project3.service.Organization_HRServices;
import com.example.project3.util.HibernateSessionUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.util.JSONPObject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Session;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@Path("/organization_hr")
public class Organization_HRController {
    private ObjectMapper objectMapper;

   Organization_HRServices organization_hrServices = new Organization_HRServices();

    @GET
    @Path("/get_all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrganizations_HR(){

        System.out.print("Hii");
        List<Organization_HR> organizationList =organization_hrServices.getOrganSer_HR();
        return Response.ok().entity(organizationList).build();
    }
    @POST
    @Path("/add/{o}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createorg_hr(@PathParam("o") Integer o, Organization_HR obj) throws JsonProcessingException {
        Session session= HibernateSessionUtil.getSession();
        Organization or=new Organization();
        or.setO_id(o);
        obj.setOrganization_id(or);
//        return Response.ok().entity(obj.getOrg_id()).build();
        Boolean organization =organization_hrServices.createorganization_hr(obj);
        if(organization)
            return Response.ok().entity(organization).build();
        else
            return Response.status(400).build();
    }

    @POST
    @Path("/get/{o}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrganizations_HR(@PathParam("o") Integer o){
        System.out.print("Hii");
//        n.setOrganization_id(n.getOrg());
        List<Organization_HR> organizationList =organization_hrServices.getOrganSer_HR(o);
        return Response.ok().entity(organizationList).build();
    }
    @POST
    @Path("/delete/{o}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete_HR(@PathParam("o") Integer o){
        System.out.print("Hii");
        organization_hrServices.deleteorganSer_HR(o);
        return Response.ok().build();
    }

    @POST
    @Path("/update/{n}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("n") Integer n, Organization_HR o){
        System.out.print("Hii");
        organization_hrServices.updateOrg_hr(n,o);
        return Response.ok().build();
    }
}
