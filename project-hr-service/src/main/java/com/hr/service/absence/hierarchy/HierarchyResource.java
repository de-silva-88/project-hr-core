package com.hr.service.absence.hierarchy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/hierarchy")
public class HierarchyResource {
    
    private HierarchyController controller;
    
    { controller = new HierarchyController(); }
    
    @GET
    public Response getNextApprover() {
        // FIX ME : NOT IMPLEMENTED YET
        // FOLLOWING IS JUST A DUMMY IMPLEMENTATION INTENDED FOR ANOTHER SERVICE
        return Response.status(Response.Status.OK).entity(controller.getNextApprover()).build();
    }
}
