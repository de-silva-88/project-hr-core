package com.hr.service.department;

import com.hr.jooq.tables.pojos.Department;
import java.util.List;

public class DepartmentController {
    private DepartmentModel departmentModel;
    {departmentModel = new DepartmentModel();}
    
    public List<Department> loadDepartmentList(){
        List<Department> departmentList = departmentModel.getDepartmentList();
        return departmentList;
    }
}
