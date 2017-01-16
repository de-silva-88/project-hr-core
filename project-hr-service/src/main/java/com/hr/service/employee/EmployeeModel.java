package com.hr.service.employee;

import com.hr.api.domain.BankData;
import com.hr.api.domain.EmployeeDetails;
import com.hr.api.domain.EmployeePersonalDetails;
import com.hr.api.domain.EmployeeWork;
import com.hr.data.dao.DataFactory;
import com.hr.data.dao.bank.BankDataApi;
import com.hr.data.dao.employee.EmployeeDataApi;
import com.hr.jooq.tables.pojos.Employee;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmployeeModel {
    private EmployeeDataApi empDataApi;
    private BankDataApi bankDataApi;
    {
        empDataApi = DataFactory.getInstanceEmployeeDataAPI();
        bankDataApi = DataFactory.getInstanceBankDataAPI();
    }
    
    public List<Employee> getEmployeeList(){
        List<Employee> empList = empDataApi.getEmployeeList();
        log.info("Employee list : {}", empList);
        return empList;
    }
    public EmployeeDetails getEmployeeById(int empNumber){
        List<EmployeePersonalDetails> personalData = getPersonalDetailById(empNumber);
        List<EmployeeWork> workingDataList = getWokingDetailsById(empNumber);
        List<BankData> bankDataList = getBankDataById(empNumber);
        EmployeeDetails empData = new EmployeeDetails();
        empData.setEmpNumber(empNumber);
        empData.setPersonalData(personalData);
        empData.setWorkingData(workingDataList);
        empData.setBankData(bankDataList);
        log.info("Employee data for emp id {} : {}", empNumber, empData);
        return empData;
    }
    
    private List<EmployeePersonalDetails> getPersonalDetailById(int empNumber){
        List<EmployeePersonalDetails> personalData = empDataApi.getEmpPersonalDetailsById(empNumber);
        log.info("Employee personal data for emp id = {} : {}", empNumber, personalData);
        return personalData;
    }
    
    private List<EmployeeWork> getWokingDetailsById(int empNumber){
        List<EmployeeWork> workingDataList = empDataApi.getEmpWorkDetailsById(empNumber);
        log.info("Employee working data for emp id = {} : {}", empNumber, workingDataList);
        return workingDataList;
    }
    
    private List<BankData> getBankDataById(int empNumber){
        List<BankData> bankDataList = bankDataApi.getEmployeeBankData(empNumber);
        log.info("Employee bank data for emp id = {} : {}", empNumber, bankDataList);
        return bankDataList;
    }
}
