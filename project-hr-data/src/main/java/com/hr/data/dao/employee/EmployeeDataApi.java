package com.hr.data.dao.employee;

import com.hr.api.domain.EmployeePersonalDetails;
import com.hr.api.domain.EmployeeWork;
import com.hr.jooq.tables.pojos.Employee;
import java.util.List;

public interface EmployeeDataApi {
    List<Employee> getEmployeeList();
    List<EmployeePersonalDetails> getEmpPersonalDetailsById(int empId);
    List<EmployeeWork> getEmpWorkDetailsById(int empId);
}
