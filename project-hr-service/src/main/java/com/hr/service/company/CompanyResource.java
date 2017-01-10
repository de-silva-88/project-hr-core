package com.hr.service.company;

import com.hr.jooq.tables.pojos.Company;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/company")
public class CompanyResource {
    private CompanyController companyController;
    private CompanyValidator companyValidator;
    
    {
        companyController = new CompanyController();
        companyValidator = new CompanyValidator();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response loadCompanyList(){
        log.info("invoke get-company-list-service");
        List<Company> companyList = companyController.getActiveCompanyList();
        return Response.status(Response.Status.OK).entity(companyList).build();
    }
    
    @GET
    @Path("/{id}")
    public Response getCompanyById(@PathParam("id") String idStr){
        log.info("invoke get-company-by-id-service with param id --> {}", idStr);
        boolean validated = companyValidator.validateGetCompanyByIdService(idStr);
        if(!validated) return Response.status(Response.Status.BAD_REQUEST).build();
        List<Company> companyList = companyController.getCompanyById(idStr);
        return Response.status(Response.Status.OK).entity(companyList).build();
    }
}
