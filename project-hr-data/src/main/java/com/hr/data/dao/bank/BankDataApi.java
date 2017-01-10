package com.hr.data.dao.bank;

import com.hr.api.domain.BankData;
import java.util.List;

public interface BankDataApi {
//    List<Bank> getBankList();
    List<BankData> getEmployeeBankData(int empNumber);
}
