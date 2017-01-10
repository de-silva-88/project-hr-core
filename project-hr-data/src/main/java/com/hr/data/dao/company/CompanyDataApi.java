package com.hr.data.dao.company;

import com.hr.jooq.tables.pojos.Company;
import java.util.List;

public interface CompanyDataApi {
    List<Company> getCompanyList();
    List<Company> getCompanyById(int companyId);
}
