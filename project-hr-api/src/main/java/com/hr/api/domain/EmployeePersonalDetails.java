package com.hr.api.domain;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class EmployeePersonalDetails {
    private Integer id;
    private String cardNumber;
    private String gender;
    private String title;
    private String initials;
    private String firstName;
    private String lastName;
    private String fullName;
    private String nicName;
    private Date dob;
    private String nic;
    private String civilStatus;
    private String religion;
    private String race;
    private String nationality;
    private String bloodGroup;
    private String tshirtSIze;
    private String collarSize;
    private String empImage;
    private String personalEmail;
    
}
