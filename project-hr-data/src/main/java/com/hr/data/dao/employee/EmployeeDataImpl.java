package com.hr.data.dao.employee;

import com.hr.data.db.MySQLConn;

import static com.hr.jooq.tables.Employee.EMPLOYEE;
import static com.hr.jooq.tables.Gender.GENDER;
import static com.hr.jooq.tables.Title.TITLE;
import com.hr.jooq.tables.pojos.Employee;
import java.io.IOException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

@Slf4j
public class EmployeeDataImpl implements EmployeeDataApi{

    @Override
    public List<Employee> getEmployeeList() {
        try (MySQLConn mysqlConn = new MySQLConn()) {
            DSLContext create = DSL.using(mysqlConn.getConnection(), SQLDialect.MYSQL);
            List<Employee> into = create.select(EMPLOYEE.ID, EMPLOYEE.FIRST_NAME, EMPLOYEE.LAST_NAME, EMPLOYEE.FULL_NAME)
                    .from(EMPLOYEE)
                    .where(EMPLOYEE.EMP_STATUS.eq(1))
                    .fetch().into(Employee.class);
            log.info("Employee list : {}", into);
            return into;
        } catch (IOException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null.");
            return null;
        }
    }

    @Override
    public List<Employee> getEmployeeById(int empId) {
        try (MySQLConn mysqlConn = new MySQLConn()) {
            DSLContext create = DSL.using(mysqlConn.getConnection(), SQLDialect.MYSQL);
            List<Employee> into = create.select(EMPLOYEE.ID, EMPLOYEE.CARD_NUMBER, GENDER.GENDER_NAME.as("gender"), 
                    TITLE.TITLE_NAME.as("title"), EMPLOYEE.INITIALS, EMPLOYEE.FIRST_NAME, EMPLOYEE.LAST_NAME, 
                    EMPLOYEE.FULL_NAME, EMPLOYEE.NIC_NAME, EMPLOYEE.DOB, EMPLOYEE.NIC)
                    .from(EMPLOYEE)
                    .leftOuterJoin(GENDER).on(EMPLOYEE.GENDER_ID.eq(GENDER.GENDER_ID))
                    .leftOuterJoin(TITLE).on(EMPLOYEE.TITLE_ID.eq(TITLE.TITLE_ID))
                    .where(EMPLOYEE.EMP_STATUS.eq(1)
                            .and(EMPLOYEE.ID.eq(empId)))
                    .fetch().into(Employee.class);
            log.info("Employee id {} : {}", empId, into);
            return into;
        } catch (IOException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null.");
            return null;
        }
    }
    
}
