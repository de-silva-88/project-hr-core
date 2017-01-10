package com.hr.service.department;

import com.hr.data.dao.DataFactory;
import com.hr.data.dao.department.DepartmentDataApi;
import com.hr.jooq.tables.pojos.Department;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DepartmentModel {
    private DepartmentDataApi departmentDataApi;
    {departmentDataApi = DataFactory.getInstanceDepartmentDataAPI();}
    
    public List<Department> getDepartmentList(){
        List<Department> departmentList = departmentDataApi.getDepartmentList();
        log.info("department list : {}", departmentList);
        return departmentList;
    }
}
