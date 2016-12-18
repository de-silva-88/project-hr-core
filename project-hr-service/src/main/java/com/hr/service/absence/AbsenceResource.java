package com.hr.service.absence;

import com.hr.api.domain.Employee;
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
	
	private AbsenceController controller = new AbsenceController();
	
        @GET
	@Path("/{id}")
        @Produces(MediaType.APPLICATION_JSON)
	public Response getLeavesLeftById(@PathParam("id") String idStr) {
		log.info("Invoked get-leaves-left-by-id service with param --> id : {}", idStr);
		int id = Integer.parseInt(idStr);
		Employee emp = controller.getLeavesLeftForEmployee(id);
		return Response.status(Response.Status.OK).entity(emp).build();
	}
}
