package com.hr.service.absence;

import com.hr.api.domain.LeavesAppliedBasic;
import com.hr.api.domain.LeavesLeftBasic;
import java.util.List;

public class AbsenceController {

    private AbsenceModel model;

    { model = new AbsenceModel(); }

    public List<LeavesLeftBasic> getLeavesLeft(String empIdStr) {
        int empId = Integer.parseInt(empIdStr);
        List<LeavesLeftBasic> leavesLeft = model.getLeavesLeft(empId);
        return leavesLeft;
    }
    
    public List<LeavesAppliedBasic> getLeavesApplied(String empIdStr) {
        int empId = Integer.parseInt(empIdStr);
        List<LeavesAppliedBasic> leavesApplied = model.getLeavesApplied(empId);
        return leavesApplied;
    }
}
