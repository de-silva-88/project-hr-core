package com.hr.data.dao.department;

import com.hr.jooq.tables.pojos.Department;
import java.util.List;

public interface DepartmentDataApi {
    List<Department> getDepartmentList();
    List<Department> getDepartmentById(int departmentId);
}
