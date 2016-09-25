package com.hr.service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.hr.api.domain.Employee;
import com.hr.service.service.AbsenceService;
import com.hr.service.service.impl.AbsenceServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/absence")
public class AbsenceResource {
	
	private AbsenceService service = new AbsenceServiceImpl();
	
	@RequestMapping(path = "/{id}", method = RequestMethod.POST)
	public ResponseEntity<Employee> getLeavesLeftById(@PathVariable("id") String idStr) {
		log.info("Invoked get-leaves-left-by-id service with param --> id : {}", idStr);
		int id = Integer.parseInt(idStr);
		Employee emp = service.getLeavesLeftForEmployee(id);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
}
