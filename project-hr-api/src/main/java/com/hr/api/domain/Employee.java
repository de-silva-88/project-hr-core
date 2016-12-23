package com.hr.api.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Employee {

    private int id;
    private String fname;
    private String lname;
    private boolean isActive;
}
