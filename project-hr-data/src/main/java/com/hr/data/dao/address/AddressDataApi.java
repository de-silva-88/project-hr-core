package com.hr.data.dao.address;

import com.hr.api.domain.AddressDetails;
import java.util.List;

public interface AddressDataApi {
    List<AddressDetails> getEmployeeAddress(int empNumber);
}
