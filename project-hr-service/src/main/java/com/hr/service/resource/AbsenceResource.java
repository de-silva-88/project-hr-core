package com.hr.service.resource;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/absence")
public class AbsenceResource {
	
	@POST
	public Response getLeavesLeftById(String idStr) {
		log.info("Invoked get-leaves-left-by-id service with param --> id : {}", idStr);
		ObjectMapper mapper = new ObjectMapper();
		int id = Integer.parseInt(idStr);
		return Response.status(Status.OK).entity("Works fine").build();
	}
}
