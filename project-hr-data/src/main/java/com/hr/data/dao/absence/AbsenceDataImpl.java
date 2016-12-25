package com.hr.data.dao.absence;

import com.hr.api.domain.LeavesAppliedBasic;
import com.hr.api.domain.LeavesLeftBasic;
import com.hr.data.db.MySQLConn;
import static com.hr.jooq.tables.Employee.EMPLOYEE;
import static com.hr.jooq.tables.LeavesApplied.LEAVES_APPLIED;
import static com.hr.jooq.tables.LeavesLeft.LEAVES_LEFT;
import static com.hr.jooq.tables.LeaveType.LEAVE_TYPE;
import static com.hr.jooq.tables.AppliedLeaveStatus.APPLIED_LEAVE_STATUS;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                    .where(
                            LEAVES_LEFT.EMP_ID.eq(empId)
                            .and(LEAVES_LEFT.IS_ACTIVE.equal((byte) 1))
                    )
                    .fetch().into(LeavesLeftBasic.class);
            log.info("leaves list : {}", leavesList);
            return leavesList;
        } catch (IOException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null.");
            return null;
        }
    }

    @Override
    public List<LeavesAppliedBasic> getLeavesAppliedByEmpId(int empId) {
        try (MySQLConn mySQLConn = new MySQLConn()) {
            Connection connection = mySQLConn.getConnection();
            DSLContext create = DSL.using(connection, SQLDialect.MYSQL);
            List<LeavesAppliedBasic> result = create
                    .select(
                            LEAVES_APPLIED.APPLIED_ON, LEAVES_APPLIED.EMP_ID, LEAVES_APPLIED.LEAVE_FROM,
                            LEAVES_APPLIED.LEAVE_TO, LEAVE_TYPE.TYPE.as("LEAVE_TYPE"),
                            LEAVES_APPLIED.REVIEWED_ON, EMPLOYEE.FULL_NAME.as("REVIEWED_BY"), APPLIED_LEAVE_STATUS.STATUS
                    ).from(LEAVES_APPLIED)
                    .leftOuterJoin(EMPLOYEE).on(LEAVES_APPLIED.REVIEWED_BY.equal(EMPLOYEE.ID))
                    .leftOuterJoin(APPLIED_LEAVE_STATUS).on(LEAVES_APPLIED.STATUS.equal(APPLIED_LEAVE_STATUS.ID))
                    .leftOuterJoin(LEAVE_TYPE).on(LEAVES_APPLIED.LEAVE_TYPE.equal(LEAVE_TYPE.ID))
                    .where(
                            LEAVES_APPLIED.EMP_ID.equal(empId)
                            .and(LEAVES_APPLIED.IS_ACTIVE.equal((byte) 1))
                    )
                    .fetch().into(LeavesAppliedBasic.class);
            return result;
        } catch (IOException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null.");
            return null;
        }
    }
}
