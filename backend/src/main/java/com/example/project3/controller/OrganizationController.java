package com.example.project3.controller;

import com.example.project3.bean.Organization;
import com.example.project3.service.OrganizationService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;


@Path("/organization")
public class OrganizationController {
    OrganizationService OrganizationServices=new OrganizationService();
    @GET
    @Path("/get_all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrganizations(){
        System.out.print("Hii");
        List<Organization> organizationList =OrganizationServices.getOrganization();
        return Response.ok().entity(organizationList).build();
    }
    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createorg(Organization obj){
        System.out.print("Hii");
        Boolean organization =OrganizationServices.createorganization(obj);
        return Response.ok().entity(organization).build();
    }
    @POST
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrganizations(Organization n){
        System.out.print("Hii");
        List<Organization> organizationList =OrganizationServices.getOrganizationN(n);
        return Response.ok().entity(organizationList).build();
    }
    @POST
    @Path("/delete")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(Organization n){
        System.out.print("Hii");
        OrganizationServices.deleteorganization(n);
        return Response.ok().build();
    }

    @POST
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    public Response Update(Organization o){
        System.out.print("Hii");

        OrganizationServices.updateOrg(o);
        return Response.ok().build();
    }

}
