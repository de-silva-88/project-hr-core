package com.hr.api.domain;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeDetails {
    private int empNumber;
    private List<EmployeePersonalDetails> personalData;
    private List<EmployeeWork> workingData;
    private List<BankData> bankData;
    
}
