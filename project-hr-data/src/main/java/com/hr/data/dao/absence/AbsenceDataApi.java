package com.hr.data.dao.absence;

import com.hr.api.domain.LeavesAppliedBasic;
import com.hr.api.domain.LeavesLeftBasic;
import java.util.List;

public interface AbsenceDataApi {
    
    List<LeavesLeftBasic> getLeavesLeftByEmpId(int empId);
    
    List<LeavesAppliedBasic> getLeavesAppliedByEmpId(int empId);
}
