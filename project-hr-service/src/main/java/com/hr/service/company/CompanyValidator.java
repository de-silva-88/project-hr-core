package com.hr.service.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CompanyValidator {
    private boolean isNumber(String numberStr) {
        Pattern p = Pattern.compile("\\d");
        Matcher matcher = p.matcher(numberStr);
        return matcher.find();
    }
    
    public boolean validateGetCompanyByIdService(String companyId) {
        if (isNumber(companyId)) {
            log.info("Inbound parameters  [companyId : {}] are ok.", companyId);
            return true;
        } else {
            log.info("Inbound parameters  [companyId : {}] are not ok. companyId is not a number", companyId);
            return false;
        }
    }
}
