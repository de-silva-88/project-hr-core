package com.hr.service.absence;

import com.hr.api.domain.LeavesAppliedBasic;
import com.hr.api.domain.LeavesLeftBasic;
import com.hr.data.dao.DataFactory;
import com.hr.data.dao.absence.AbsenceDataApi;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AbsenceModel {

    private AbsenceDataApi abDataApi;

    { abDataApi = DataFactory.getInstanceAbsenceDataAPI(); }
    
    public List<LeavesLeftBasic> getLeavesLeft(int empId) {
        List<LeavesLeftBasic> leavesLeft = abDataApi.getLeavesLeftByEmpId(empId);
        log.info("leaves left : {}", leavesLeft);
        return leavesLeft;
    }
    
    public List<LeavesAppliedBasic> getLeavesApplied(int empId) {
        List<LeavesAppliedBasic> leavesApplied = abDataApi.getLeavesAppliedByEmpId(empId);
        log.info("leaves applied : {}", leavesApplied);
        return leavesApplied;
    }
}
