package com.hr.service.absence;

import com.hr.jooq.tables.pojos.Employee;
import java.util.List;

public class AbsenceModel {

    private AbsenceDAO abDAO;

    {
        abDAO = new AbsenceDAO();
    }
    
    public List<Employee> getLeavesLeft() {
        List<Employee> leavesLeftByEmpId = abDAO.getLeavesLeftByEmpId();
        return leavesLeftByEmpId;
    }
}
