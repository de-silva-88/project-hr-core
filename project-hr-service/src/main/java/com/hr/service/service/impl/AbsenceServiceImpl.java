package com.hr.service.service.impl;

import com.hr.api.domain.Employee;
import com.hr.service.service.AbsenceService;

public class AbsenceServiceImpl implements AbsenceService {

	@Override
	public Employee getLeavesLeftForEmployee(int id) {
		Employee emp = new Employee();
		emp.setActive(true);
		emp.setFname("Jerrad");
		emp.setId(21);
		emp.setLname("Butler");
		return emp;
	}
}
