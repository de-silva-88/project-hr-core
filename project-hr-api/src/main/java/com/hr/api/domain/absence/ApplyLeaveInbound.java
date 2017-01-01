package com.hr.api.domain.absence;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ApplyLeaveInbound {
    
    private int employeeId;
    private int leaveType;
    private String leaveToDate;
    private String leaveFromDate;
    private Timestamp leaveTo;
    private Timestamp leaveFrom;
    private int status;
    private String appliedOnDate;
    private Timestamp appliedOn;
}
