package com.hr.service.employee;

import com.hr.jooq.tables.pojos.Employee;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/employee")
public class EmployeeResource {
    private EmployeeController empController;
    private EmployeeValidator empValidator;
    {
        empController = new EmployeeController();
        empValidator = new EmployeeValidator();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response loadEmployeeList(){
        log.info("invoke load-employee-list service");
        List<Employee> empList = empController.getActiveEmployeeList();
        return Response.status(Response.Status.OK).entity(empList).build();
    }
    
    @GET
    @Path("/leaves/left/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response loadEmployee(@PathParam("id") String idStr){
        log.info("invoke load-employee-by-id service with param id --> {}", idStr);
        boolean validated = empValidator.validateEmployeeId(idStr);
        if(!validated) return Response.status(Response.Status.BAD_REQUEST).build();
        List<Employee> empList = empController.getEmployee(idStr);
        return Response.status(Response.Status.OK).entity(empList).build();
    }
}
