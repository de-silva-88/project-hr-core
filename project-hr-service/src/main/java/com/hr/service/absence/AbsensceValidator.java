package com.hr.service.absence;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.extern.slf4j.Slf4j;

@Slf4j()
public class AbsensceValidator {

    public boolean validateGetLeavesLeftService(String empId) {
        if (isNumber(empId)) {
            log.info("Inbound parameters  [empId : {}] are ok.", empId);
            return true;
        } else {
            log.info("Inbound parameters  [empId : {}] are not ok. Empid is not a number", empId);
            return false;
        }
    }
    
    public boolean validateGetLeavesAppliedService(String empId) {
        if (isNumber(empId)) {
            log.info("Inbound parameters  [empId : {}] are ok.", empId);
            return true;
        } else {
            log.info("Inbound parameters  [empId : {}] are not ok. Empid is not a number", empId);
            return false;
        }
    }
    
    private boolean isNumber(String numberStr) {
        Pattern p = Pattern.compile("\\d");
        Matcher matcher = p.matcher(numberStr);
        return matcher.find();
    }
}
