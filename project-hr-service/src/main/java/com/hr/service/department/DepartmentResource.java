package com.hr.service.department;

import com.hr.jooq.tables.pojos.Department;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/department")
@Produces(MediaType.APPLICATION_JSON)
public class DepartmentResource {
    private DepartmentController departmentController;
    {departmentController = new DepartmentController();}
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDepartmentList(){
        log.info("Invoked get-departmetnt-list service");
        List<Department> departmentList = departmentController.loadDepartmentList();
        return Response.status(Response.Status.OK).entity(departmentList).build();
    }
    
}
