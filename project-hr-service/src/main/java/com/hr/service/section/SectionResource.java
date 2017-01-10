package com.hr.service.section;

import com.hr.jooq.tables.pojos.Section;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/section")
public class SectionResource {
    private SectionController secController;
    {secController = new SectionController();}
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSectionList(){
        log.info("Invoked get-section-list service");
        List<Section> sectionList = secController.loadSectionList();
        return Response.status(Response.Status.OK).entity(sectionList).build();
    }
    
    
}
