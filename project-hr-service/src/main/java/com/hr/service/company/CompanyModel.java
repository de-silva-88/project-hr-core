package com.hr.service.company;

import com.hr.data.dao.DataFactory;
import com.hr.data.dao.company.CompanyDataApi;
import com.hr.jooq.tables.pojos.Company;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CompanyModel {
    private CompanyDataApi comDataApi;
    {comDataApi = DataFactory.getInstanceCompanyDataAPI();}
    
    public List<Company> getCompanyList(){
        List<Company> comList = comDataApi.getCompanyList();
        log.info("Company list : {}", comList);
        return comList;
    }
    
    public List<Company> getCompanyById(int companyId){
        List<Company> comList = comDataApi.getCompanyById(companyId);
        log.info("Company id = {} : {}", companyId, comList);
        return comList;
    }
}
