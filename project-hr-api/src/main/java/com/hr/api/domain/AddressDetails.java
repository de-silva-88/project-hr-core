package com.hr.api.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AddressDetails {
    private Integer id;
    private Integer empNumber;
    private String addressType;
    private String houseNo;
    private String street;
    private String city;
    private String district;
    private String postalCode;
}
