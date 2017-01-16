package com.hr.service.employee;

import com.hr.api.domain.EmployeeDetails;
import com.hr.jooq.tables.pojos.Employee;
import java.util.List;

public class EmployeeController {
    private EmployeeModel empModel;
    {empModel = new EmployeeModel();}
    
    public List<Employee> getActiveEmployeeList(){
        List<Employee> empList = empModel.getEmployeeList();
        return empList;
    }
    
    public EmployeeDetails getEmployee(String empNumber){
        int empId = Integer.parseInt(empNumber);
        EmployeeDetails empData = empModel.getEmployeeById(empId);
        return empData;
    }
}
