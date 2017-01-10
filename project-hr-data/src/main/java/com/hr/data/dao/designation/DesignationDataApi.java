package com.hr.data.dao.designation;

import com.hr.jooq.tables.pojos.Designation;
import java.util.List;

public interface DesignationDataApi {
    List<Designation> getDesignationList();
}
