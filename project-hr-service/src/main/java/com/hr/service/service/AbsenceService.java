package com.hr.service.service;

import com.hr.api.domain.Employee;

public interface AbsenceService {
	
	Employee getLeavesLeftForEmployee(int id);
}
