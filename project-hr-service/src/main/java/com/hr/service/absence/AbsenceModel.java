package com.hr.service.absence;

import com.hr.api.domain.LeavesLeftBasic;
import com.hr.data.dao.DataFactory;
import com.hr.data.dao.absence.AbsenceDataApi;
import java.util.List;

public class AbsenceModel {

    private AbsenceDataApi abDataApi;

    { abDataApi = DataFactory.getInstanceAbsenceDataAPI(); }
    
    public List<LeavesLeftBasic> getLeavesLeft(int empId) {
        List<LeavesLeftBasic> leavesLeftByEmpId = abDataApi.getLeavesLeftByEmpId(empId);
        return leavesLeftByEmpId;
    }
}
