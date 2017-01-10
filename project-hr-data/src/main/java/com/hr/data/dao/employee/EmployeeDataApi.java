package com.hr.data.dao.employee;

import com.hr.jooq.tables.pojos.Employee;
import java.util.List;

public interface EmployeeDataApi {
    List<Employee> getEmployeeList();
    List<Employee> getEmployeeById(int empId);
}
