package com.hr.data.dao.department;

import com.hr.data.db.MySQLConn;
import static com.hr.jooq.tables.Department.DEPARTMENT;
import com.hr.jooq.tables.pojos.Department;
import java.io.IOException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

@Slf4j
public class DepartmentDataImpl implements DepartmentDataApi{

    @Override
    public List<Department> getDepartmentList() {
        try (MySQLConn mysqlConn = new MySQLConn()) {
            DSLContext create = DSL.using(mysqlConn.getConnection(), SQLDialect.MYSQL);
            List<Department> into = create.select(DEPARTMENT.DEPARTMENT_ID, DEPARTMENT.DEPARTMENT_NAME, DEPARTMENT.DESCRIPTION)
                    .from(DEPARTMENT)
                    .where(DEPARTMENT.IS_ACTIVE.eq(Byte.valueOf("1")))
                    .fetch().into(Department.class);
            log.debug("Department list = {}", into);
            return into;
        } catch (IOException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null.");
            return null;
        }
    }

    @Override
    public List<Department> getDepartmentById(int departmentId) {
        try (MySQLConn mysqlConn = new MySQLConn()) {
            DSLContext create = DSL.using(mysqlConn.getConnection(), SQLDialect.MYSQL);
            List<Department> into = create.select(DEPARTMENT.DEPARTMENT_ID, DEPARTMENT.DEPARTMENT_NAME, DEPARTMENT.DESCRIPTION)
                    .from(DEPARTMENT)
                    .where(DEPARTMENT.IS_ACTIVE.eq(Byte.valueOf("1"))
                            .and(DEPARTMENT.DEPARTMENT_ID.eq(departmentId)))
                    .fetch().into(Department.class);
            log.debug("Department id = {} : {}",departmentId , into);
            return into;
        } catch (IOException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null.");
            return null;
        }
    }
    
}
