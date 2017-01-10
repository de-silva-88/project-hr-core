package com.hr.data.dao.section;

import com.hr.jooq.tables.pojos.Section;
import java.util.List;

public interface SectionDataApi {
    List<Section> getSectionList();
    List<Section> getSectionById(int sectionId);
}
