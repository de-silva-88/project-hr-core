package com.hr.service.section;

import com.hr.jooq.tables.pojos.Section;
import java.util.List;

public class SectionController {
    private SectionModel sectionModel;
    {sectionModel = new SectionModel();}
    
    public List<Section> loadSectionList(){
        List<Section> secList = sectionModel.getSectionList();
        return secList;
    }
    
    public List<Section> getSectionById(String id){
        int secId = Integer.parseInt(id);
        List<Section> secList = sectionModel.getSectionById(secId);
        return secList;
    }
}
