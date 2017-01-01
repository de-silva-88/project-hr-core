package com.hr.service.absence;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hr.api.domain.absence.ApplyLeaveInbound;
import com.hr.api.domain.common.ValidationResult;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.extern.slf4j.Slf4j;

@Slf4j()
public class AbsensceValidator {

    public ValidationResult validateGetLeavesLeftService(String empId) {
        if (isNumber(empId)) {
            log.info("Inbound parameters  [empId : {}] are ok.", empId);
            return new ValidationResult(true, null);
        } else {
            log.info("Inbound parameters  [empId : {}] are not ok. Empid is not a number", empId);
            return new ValidationResult(false, "Inbound parameters  [empId : "
                    + empId + "] are not ok. Empid is not a number");
        }
    }

    public ValidationResult validateGetLeavesAppliedService(String empId) {
        if (isNumber(empId)) {
            log.info("Inbound parameters  [empId : {}] are ok.", empId);
            return new ValidationResult(true, null);
        } else {
            log.info("Inbound parameters  [empId : {}] are not ok. Empid is not a number", empId);
            return new ValidationResult(false, "Inbound parameters  [empId : "
                    + empId + "] are not ok. Empid is not a number");
        }
    }

    public ValidationResult validateApplyLeaveService(String inboundParams) {
        ObjectMapper mapper = new ObjectMapper();
        ApplyLeaveInbound applyLeveInfo;
        try {
            applyLeveInfo = mapper.readValue(inboundParams, new TypeReference<ApplyLeaveInbound>() {
            });
        } catch (IOException ex) {
            log.error("Cannot map json to type:ApplyLeaveInbound. Err msg : {}", ex.getMessage());
            return new ValidationResult(false, "JSon is not the expected format. Check the attributes and values again.");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            sdf.parse(applyLeveInfo.getLeaveFromDate());
            sdf.parse(applyLeveInfo.getLeaveToDate());
            sdf.parse(applyLeveInfo.getAppliedOnDate());
        } catch (ParseException ex) {
            log.error("Date format is wrong. Err msg : {}", ex.getMessage());
            return new ValidationResult(false, "DateFormat is incorrect");
        }
        return new ValidationResult(true, null);
    }

    private boolean isNumber(String numberStr) {
        Pattern p = Pattern.compile("\\d");
        Matcher matcher = p.matcher(numberStr);
        return matcher.find();
    }
}
