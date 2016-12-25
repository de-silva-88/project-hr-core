package com.hr.api.domain;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LeavesLeftBasic {
    
    private Integer empId;
    private String type;
    private BigDecimal leavesLeft;
}
