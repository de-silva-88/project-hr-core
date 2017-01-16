package com.hr.data.dao;

import com.hr.data.dao.absence.AbsenceDataApi;
import com.hr.data.dao.absence.AbsenceDataImpl;
import com.hr.data.dao.bank.BankDataApi;
import com.hr.data.dao.bank.BankDataImpl;
import com.hr.data.dao.company.CompanyDataApi;
import com.hr.data.dao.company.CompanyDataImpl;
import com.hr.data.dao.department.DepartmentDataApi;
import com.hr.data.dao.department.DepartmentDataImpl;
import com.hr.data.dao.employee.EmployeeDataApi;
import com.hr.data.dao.employee.EmployeeDataImpl;
import com.hr.data.dao.section.SectionDataApi;
import com.hr.data.dao.section.SectionDataImpl;
import com.hr.data.extrainfo.ExtraInfoDataApi;
import com.hr.data.extrainfo.ExtraInfoDataImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataFactory {
    
    public static AbsenceDataApi getInstanceAbsenceDataAPI () {
        log.info("Get instance of absence-data-api");
        AbsenceDataApi absenceDataApi = new AbsenceDataImpl();
        return absenceDataApi;
    }
    
    public static CompanyDataApi getInstanceCompanyDataAPI () {
        log.info("Get instance of company-data-api");
        CompanyDataApi companyDataApi = new CompanyDataImpl();
        return companyDataApi;
    }
    
    public static DepartmentDataApi getInstanceDepartmentDataAPI () {
        log.info("Get instance of department-data-api");
        DepartmentDataApi departmentDataApi = new DepartmentDataImpl();
        return departmentDataApi;
    }
    
    public static SectionDataApi getInstanceSectionDataAPI () {
        log.info("Get instance of section-data-api");
        SectionDataApi sectionDataApi = new SectionDataImpl();
        return sectionDataApi;
    }
    
    public static ExtraInfoDataApi getInstanceExtraInfoDataAPI () {
        log.info("Get instance of extraInfo-data-api");
        ExtraInfoDataApi extraInfoDataApi = new ExtraInfoDataImpl();
        return extraInfoDataApi;
    }
    
    public static EmployeeDataApi getInstanceEmployeeDataAPI () {
        log.info("Get instance of employee-data-api");
        EmployeeDataApi employeeDataApi = new EmployeeDataImpl();
        return employeeDataApi;
    }
    
    public static BankDataApi getInstanceBankDataAPI(){
        log.info("Get instance of employee-bank-data-api");
        BankDataApi bankDataApi = new BankDataImpl();
        return bankDataApi;
    }
}
