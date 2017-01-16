package com.hr.api.domain;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeWork {
    private int id;
    private int empNumber;
    private String company;
    private String department;
    private String section;
    private String location;
    private String empType;
    private String workingType;
    private Date appointmentDate;
    private int probation;
    private int probationDuration;
    private int probationExtended;
    private int proExtndDuration;
    private String officeEmail;
    private double distanceFromResidence;
    private int vehicleIssued;
    private String vehicleType;
    private String vehicleNumber;
    private int vehiclePassIssued;
    private String vehiclePassNumber;
    private int overtime;
    private String overtimeRate;
    private String description;
}
