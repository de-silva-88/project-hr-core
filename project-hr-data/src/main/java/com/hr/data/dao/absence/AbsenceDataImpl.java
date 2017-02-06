package com.hr.data.dao.absence;

import com.hr.api.domain.absence.ApplyLeaveInbound;
import com.hr.api.domain.absence.LeavesAppliedBasic;
import com.hr.api.domain.absence.LeavesLeftBasic;
import com.hr.data.db.MySQLConn;
import com.hr.data.excetion.DataAccessException;
import static com.hr.jooq.tables.Employee.EMPLOYEE;
import static com.hr.jooq.tables.LeavesApplied.LEAVES_APPLIED;
import static com.hr.jooq.tables.LeavesLeft.LEAVES_LEFT;
import static com.hr.jooq.tables.LeaveType.LEAVE_TYPE;
import static com.hr.jooq.tables.AppliedLeaveStatus.APPLIED_LEAVE_STATUS;
import java.io.IOException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;

@Slf4j
public class AbsenceDataImpl implements AbsenceDataApi {

    @Override
    public List<LeavesLeftBasic> getLeavesLeftByEmpId(int empId) {
        try (MySQLConn mysqlConn = new MySQLConn()) {
            DSLContext create = mysqlConn.getDSLContext();
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
        } catch (IOException | DataAccessException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null. Message : {}", ex.getMessage());
            return null;
        }
    }

    @Override
    public List<LeavesAppliedBasic> getLeavesAppliedByEmpId(int empId) {
        try (MySQLConn mySQLConn = new MySQLConn()) {
            DSLContext create = mySQLConn.getDSLContext();
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
        } catch (IOException | DataAccessException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null. Message : {}", ex.getMessage());
            return null;
        }
    }

    @Override
    public int applyLeave(ApplyLeaveInbound applyLeaveInfo) {
//        try(MySQLConn mysqlConn = new MySQLConn()) {
//            DSLContext create = mysqlConn.getDSLContext();
//            int executeResult = create.insertInto(LEAVES_APPLIED, LEAVES_APPLIED.EMP_ID,
//                    LEAVES_APPLIED.LEAVE_TYPE, LEAVES_APPLIED.LEAVE_FROM, LEAVES_APPLIED.LEAVE_TO,
//                    LEAVES_APPLIED.APPLIED_ON, LEAVES_APPLIED.IS_ACTIVE, LEAVES_APPLIED.STATUS)
//                    .values(applyLeaveInfo.getEmployeeId(), applyLeaveInfo.getLeaveType(),
//                            applyLeaveInfo.getLeaveFrom(), applyLeaveInfo.getLeaveTo(),
//                            applyLeaveInfo.getAppliedOn(), (byte) 1, 1)
//                    .execute();
//            return executeResult;
//        } catch (IOException | DataAccessException ex) {
//            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with value -1. Message : {}", ex.getMessage());
            return -1;
//        }
    }
}
