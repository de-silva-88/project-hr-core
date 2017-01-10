package com.hr.service.company;

import com.hr.jooq.tables.pojos.Company;
import java.util.List;

public class CompanyController {
    private CompanyModel model;
    {model = new CompanyModel();}
    
    public List<Company> getActiveCompanyList(){
        List<Company> companyList = model.getCompanyList();
        return companyList;
    }
    
    public List<Company> getCompanyById(String comId){
        int companyId = Integer.parseInt(comId);
        List<Company> companyList = model.getCompanyById(companyId);
        return companyList;
    }
}
