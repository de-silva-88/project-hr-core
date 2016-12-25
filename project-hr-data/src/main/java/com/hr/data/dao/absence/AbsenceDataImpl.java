package com.hr.data.dao.absence;

import com.hr.api.domain.LeavesLeftBasic;
import com.hr.data.db.MySQLConn;
import static com.hr.jooq.tables.Employee.EMPLOYEE;
import static com.hr.jooq.tables.LeavesLeft.LEAVES_LEFT;
import static com.hr.jooq.tables.LeaveType.LEAVE_TYPE;
import com.hr.jooq.tables.pojos.Employee;
import java.io.IOException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

@Slf4j
public class AbsenceDataImpl implements AbsenceDataApi {

    @Override
    public List<LeavesLeftBasic> getLeavesLeftByEmpId(int empId) {
        try (MySQLConn mysqlConn = new MySQLConn()) {
            DSLContext create = DSL.using(mysqlConn.getConnection(), SQLDialect.MYSQL);
            List<LeavesLeftBasic> leavesList = create
                    .select(LEAVES_LEFT.EMP_ID, LEAVE_TYPE.TYPE, LEAVES_LEFT.LEAVES_LEFT_)
                    .from(LEAVES_LEFT)
                    .leftOuterJoin(LEAVE_TYPE).on(LEAVES_LEFT.LEAVE_TYPE.equal(LEAVE_TYPE.ID))
                    .where(LEAVES_LEFT.EMP_ID.eq(empId))
                    .fetch().into(LeavesLeftBasic.class);
            log.info("leaves list : {}", leavesList);
            return leavesList;
        } catch (IOException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null.");
            return null;
        }
    }
}
