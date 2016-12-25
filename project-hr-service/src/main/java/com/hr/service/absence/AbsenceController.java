package com.hr.service.absence;

import com.hr.api.domain.LeavesLeftBasic;
import com.hr.jooq.tables.pojos.Employee;
import java.util.List;

public class AbsenceController {

    private AbsenceModel model;

    { model = new AbsenceModel(); }

    public List<LeavesLeftBasic> getLeavesLeft(String empIdStr) {
        int empId = Integer.parseInt(empIdStr);
        List<LeavesLeftBasic> leavesLeftByEmpId = model.getLeavesLeft(empId);
        return leavesLeftByEmpId;
    }
}
