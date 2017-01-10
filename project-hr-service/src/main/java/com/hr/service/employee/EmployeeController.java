package com.hr.service.employee;

import com.hr.jooq.tables.pojos.Employee;
import java.util.List;

public class EmployeeController {
    private EmployeeModel empModel;
    {empModel = new EmployeeModel();}
    
    public List<Employee> getActiveEmployeeList(){
        List<Employee> empList = empModel.getEmployeeList();
        return empList;
    }
    
    public List<Employee> getEmployee(String empNumber){
        int empId = Integer.parseInt(empNumber);
        List<Employee> empList = empModel.getEmployeeById(empId);
        return empList;
    }
}
