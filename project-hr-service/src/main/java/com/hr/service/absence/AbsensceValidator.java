package com.hr.service.absence;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.extern.slf4j.Slf4j;

@Slf4j()
public class AbsensceValidator {

    public boolean validateGetLeavesLeftService(String empId) {
        Pattern p = Pattern.compile("\\d");
        Matcher matcher = p.matcher(empId);
        if (matcher.find()) {
            log.info("Inbound parameters  [empId : {}] are ok.", empId);
            return true;
        } else {
            log.info("Inbound parameters  [empId : {}] are not ok. Empid is not a number", empId);
            return false;
        }
    }
}
