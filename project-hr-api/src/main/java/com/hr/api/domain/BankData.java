package com.hr.api.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BankData {
    private Integer id;
    private Integer empNumber;
    private String bankName;
    private String branch;
    private String bankCode;
    private String branchCode;
    private String accountNumber;
}
