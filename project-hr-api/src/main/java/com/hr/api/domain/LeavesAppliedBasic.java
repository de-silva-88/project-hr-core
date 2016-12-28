package com.hr.api.domain;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class LeavesAppliedBasic {
    private Date appliedOn;
    private Integer empId;
    private Date leaveFrom;
    private Date leaveTo;
    private String leaveType;
    private Date reviewedOn;
    private String reviewedBy;
    private String status;
}
