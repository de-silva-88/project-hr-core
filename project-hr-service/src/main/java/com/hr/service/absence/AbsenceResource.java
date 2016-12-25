package com.hr.service.absence;

import com.hr.api.domain.LeavesLeftBasic;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/absence")
public class AbsenceResource {

    private AbsenceController controller;
    private AbsensceValidator validator;

    {
        controller = new AbsenceController();
        validator = new AbsensceValidator();
    }

    @GET
    @Path("/leaves/left/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLeavesLeftByEmpId(@PathParam("id") String idStr) {
        log.info("Invoked get-leaves-left-by-id service with param --> id : {}", idStr);
        boolean validated = validator.validateGetLeavesLeftService(idStr);
        if(!validated) return Response.status(Response.Status.BAD_REQUEST).build();
        List<LeavesLeftBasic> leavesLeft = controller.getLeavesLeft(idStr);
        return Response.status(Response.Status.OK).entity(leavesLeft).build();
    }
}
