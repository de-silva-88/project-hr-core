package com.hr.api.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class EmergencyContactDetails {
    private Integer id;
    private Integer empNumber;
    private String relationType;
    private String contactPersonName;
    private String personalNumber;
    private String companyName;
    private String designation;
    private String companyAddress;
    private String officeNumber;
}
