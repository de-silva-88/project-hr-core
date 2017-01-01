package com.hr.service.absence;

import com.hr.api.domain.absence.LeavesAppliedBasic;
import com.hr.api.domain.absence.LeavesLeftBasic;
import com.hr.api.domain.common.ValidationResult;
import com.hr.jooq.tables.pojos.LeaveType;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
        ValidationResult validationResult = validator.validateGetLeavesLeftService(idStr);
        boolean validationOk = validationResult.isSuccessful();
        if(!validationOk) return Response.status(Response.Status.BAD_REQUEST).build();
        List<LeavesLeftBasic> leavesLeft = controller.getLeavesLeft(idStr);
        return Response.status(Response.Status.OK).entity(leavesLeft).build();
    }
    
    @GET
    @Path("/leaves/applied/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLeavesAppliedByEmpId(@PathParam("id") String idStr) {
        log.info("Invoked get-leaves-applied-by-id service with param --> id : {}", idStr);
        ValidationResult validationResult = validator.validateGetLeavesAppliedService(idStr);
        boolean validationOk = validationResult.isSuccessful();
        if(!validationOk) return Response.status(Response.Status.BAD_REQUEST).build();
        List<LeavesAppliedBasic> leavesApplied = controller.getLeavesApplied(idStr);
        return Response.status(Response.Status.OK).entity(leavesApplied).build();
    }
    
    @POST
    @Path("/leaves/apply")
    @Produces(MediaType.APPLICATION_JSON)
    public Response applyLeave(String applyLeaveJSon) {
        log.info("Invoked apply-leaves service with param --> id : {}", applyLeaveJSon);
        ValidationResult validationResult = validator.validateApplyLeaveService(applyLeaveJSon);
        boolean validationOk = validationResult.isSuccessful();
        if(!validationOk) return Response.status(Response.Status.BAD_REQUEST).build();
        boolean applyLeaveResult = controller.applyLeave(applyLeaveJSon);
        if(applyLeaveResult) return Response.status(Response.Status.NO_CONTENT).build();
        else return Response.status(Response.Status.CREATED).build();
    }
    
    @GET
    @Path("/leaves/types")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllLeaveTypes() {
        log.info("Invoked get all leave types service.");
        List<LeaveType> leaveTypes = controller.getLeaveTypes();
        if (leaveTypes == null) return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        else return Response.status(Response.Status.OK).entity(leaveTypes).build();
    }
}