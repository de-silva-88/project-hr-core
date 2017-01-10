package com.hr.service.employee;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmployeeValidator {
    private boolean isNumber(String numberStr) {
        Pattern p = Pattern.compile("\\d");
        Matcher matcher = p.matcher(numberStr);
        return matcher.find();
    }
    
    public boolean validateEmployeeId(String empId) {
        if (isNumber(empId)) {
            log.info("Inbound parameters  [employeeId : {}] are ok.", empId);
            return true;
        } else {
            log.info("Inbound parameters  [employeeId : {}] are not ok. employeeId is not a number", empId);
            return false;
        }
    }
}
