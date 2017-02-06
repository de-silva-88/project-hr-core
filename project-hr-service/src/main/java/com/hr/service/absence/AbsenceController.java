package com.hr.service.absence;

//import com.hr.api.domain.LeavesAppliedBasic;
//import com.hr.api.domain.LeavesLeftBasic;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hr.api.domain.absence.ApplyLeaveInbound;
import com.hr.api.domain.absence.LeavesAppliedBasic;
import com.hr.api.domain.absence.LeavesLeftBasic;
import com.hr.jooq.tables.pojos.LeaveType;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AbsenceController {

    private AbsenceModel model;

    {
        model = new AbsenceModel();
    }

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

    public boolean applyLeave(String applyLeaveJSon) {
        ApplyLeaveInbound applyLeaveInfo;
        try {
            applyLeaveInfo = new ObjectMapper().readValue(
                    applyLeaveJSon, new TypeReference<ApplyLeaveInbound> () {});
        } catch (IOException ex) {
            log.error("Error mapping json to type : ApplyLeaveInbound. Error msg : {}", ex.getMessage());
            return false;
        }
        // set stringified dates as timestamps to execute db-insert 
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        long fromDateLong;
        long toDateLong;
        long appliedOnDateLong;
        try {
            fromDateLong = sdf.parse(applyLeaveInfo.getLeaveFromDate()).getTime();
            toDateLong = sdf.parse(applyLeaveInfo.getLeaveToDate()).getTime();
            appliedOnDateLong = sdf.parse(applyLeaveInfo.getAppliedOnDate()).getTime();
        } catch (ParseException ex) {
            log.error("Date formate error. Error msg : {}", ex.getMessage());
            return false;
        }
        applyLeaveInfo.setLeaveFrom(new Timestamp(fromDateLong));
        applyLeaveInfo.setLeaveTo(new Timestamp(toDateLong));
        applyLeaveInfo.setAppliedOn(new Timestamp(appliedOnDateLong));
        int applyLeavesResult = model.applyLeaves(applyLeaveInfo);
        if (applyLeavesResult < 1) {
            return false;
        }
        return true;
    }
    
    public List<LeaveType> getLeaveTypes() {
        return model.getAllLeaveTypes();
    }
}
