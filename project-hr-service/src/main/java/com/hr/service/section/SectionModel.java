package com.hr.service.section;

import com.hr.data.dao.DataFactory;
import com.hr.data.dao.section.SectionDataApi;
import com.hr.jooq.tables.pojos.Section;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SectionModel {
    private SectionDataApi sectionDataApi;
    {sectionDataApi = DataFactory.getInstanceSectionDataAPI();}
    
    public List<Section> getSectionList(){
        List<Section> secList = sectionDataApi.getSectionList();
        log.info("section list : {}", secList);
        return secList;
    }
    
    public List<Section> getSectionById(int id){
        List<Section> secList = sectionDataApi.getSectionById(id);
        log.info("section id = {} : {}", id , secList);
        return secList;
    }
}
