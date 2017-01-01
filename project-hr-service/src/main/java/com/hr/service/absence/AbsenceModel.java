package com.hr.service.absence;

import com.hr.api.domain.absence.ApplyLeaveInbound;
import com.hr.api.domain.absence.LeavesAppliedBasic;
import com.hr.api.domain.absence.LeavesLeftBasic;
import com.hr.data.dao.DataFactory;
import com.hr.data.dao.absence.AbsenceDataApi;
import com.hr.jooq.tables.pojos.LeaveType;
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
    
    public int applyLeaves(ApplyLeaveInbound applyLeaveInfo) {
        int applyLeaveResult = abDataApi.applyLeave(applyLeaveInfo);
        log.info("leaves applied result : {}", applyLeaveResult);
        return applyLeaveResult;
    }
    
    public List<LeaveType> getAllLeaveTypes() {
        return abDataApi.getLeaveTypes();
    }
}
