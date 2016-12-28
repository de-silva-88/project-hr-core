package com.hr.data.dao;

import com.hr.data.dao.absence.AbsenceDataApi;
import com.hr.data.dao.absence.AbsenceDataImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataFactory {
    
    public static AbsenceDataApi getInstanceAbsenceDataAPI () {
        log.info("Get instance of absence-data-api");
        AbsenceDataApi absenceDataApi = new AbsenceDataImpl();
        return absenceDataApi;
    }
}
