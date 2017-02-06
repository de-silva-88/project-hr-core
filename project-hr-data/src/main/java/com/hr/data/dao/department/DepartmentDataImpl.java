package com.hr.data.dao.department;

import com.hr.data.db.MySQLConn;
import com.hr.data.excetion.DataAccessException;
import static com.hr.jooq.tables.Department.DEPARTMENT;
import com.hr.jooq.tables.pojos.Department;
import java.io.IOException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;

@Slf4j
public class DepartmentDataImpl implements DepartmentDataApi{

    @Override
    public List<Department> getDepartmentList() {
        try (MySQLConn mysqlConn = new MySQLConn()) {
            DSLContext create = mysqlConn.getDSLContext();
            List<Department> into = create.select(DEPARTMENT.DEPARTMENT_ID, DEPARTMENT.DEPARTMENT_NAME, DEPARTMENT.DESCRIPTION)
                    .from(DEPARTMENT)
                    .where(DEPARTMENT.IS_ACTIVE.eq(Byte.valueOf("1")))
                    .fetch().into(Department.class);
            log.debug("Department list = {}", into);
            return into;
        } catch (IOException | DataAccessException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null. Message : {}", ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Department> getDepartmentById(int departmentId) {
        try (MySQLConn mysqlConn = new MySQLConn()) {
            DSLContext create = mysqlConn.getDSLContext();
            List<Department> into = create.select(DEPARTMENT.DEPARTMENT_ID, DEPARTMENT.DEPARTMENT_NAME, DEPARTMENT.DESCRIPTION)
                    .from(DEPARTMENT)
                    .where(DEPARTMENT.IS_ACTIVE.eq(Byte.valueOf("1"))
                            .and(DEPARTMENT.DEPARTMENT_ID.eq(departmentId)))
                    .fetch().into(Department.class);
            log.debug("Department id = {} : {}",departmentId , into);
            return into;
        } catch (IOException | DataAccessException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null. Message : {}", ex.getMessage());
            return null;
        }
    }
    
}
