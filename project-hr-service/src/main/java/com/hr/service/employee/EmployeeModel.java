package com.hr.service.employee;

import com.hr.data.dao.DataFactory;
import com.hr.data.dao.employee.EmployeeDataApi;
import com.hr.jooq.tables.pojos.Employee;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmployeeModel {
    private EmployeeDataApi empDataApi;
    {empDataApi = DataFactory.getInstanceEmployeeDataAPI();}
    
    public List<Employee> getEmployeeList(){
        List<Employee> empList = empDataApi.getEmployeeList();
        log.info("Employee list : {}", empList);
        return empList;
    }
    public List<Employee> getEmployeeById(int empNumber){
        List<Employee> empList = empDataApi.getEmployeeById(empNumber);
        log.info("Employee id {} : {}", empNumber, empList);
        return empList;
    }
}
