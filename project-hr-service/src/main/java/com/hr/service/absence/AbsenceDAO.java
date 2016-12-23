package com.hr.service.absence;

import static com.hr.jooq.tables.Employee.EMPLOYEE;
import com.hr.jooq.tables.pojos.Employee;
import com.hr.service.dao.MySQLConn;
import java.io.IOException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

@Slf4j
public class AbsenceDAO {

    public List<Employee> getLeavesLeftByEmpId() {
        try (MySQLConn mysqlConn = new MySQLConn()) {
            DSLContext create = DSL.using(mysqlConn.getConnection(), SQLDialect.MYSQL);
            List<Employee> into = create.select().from(EMPLOYEE).where(EMPLOYEE.ID.eq(2)).fetch().into(Employee.class);
            log.info("leaves list : {}", into);
            return into;
        } catch (IOException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null.");
            return null;
        }
    }
}
