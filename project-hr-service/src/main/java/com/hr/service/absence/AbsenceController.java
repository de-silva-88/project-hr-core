package com.hr.service.absence;

import com.hr.api.domain.Employee;
import com.hr.service.absence.AbsenceController;

public class AbsenceController {

	public Employee getLeavesLeftForEmployee(int id) {
		Employee emp = new Employee();
		emp.setActive(true);
		emp.setFname("Jerrad");
		emp.setId(21);
		emp.setLname("Butler");
		return emp;
	}
}
