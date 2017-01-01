package com.hr.data.dao.absence;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hr.api.domain.absence.ApplyLeaveInbound;
import com.hr.api.domain.absence.LeavesAppliedBasic;
import com.hr.api.domain.absence.LeavesLeftBasic;
import com.hr.data.cache.ApplicationCacheFactory;
import com.hr.data.db.MySQLConn;
import com.hr.data.excetion.DataAccessException;
import com.hr.data.util.Constants;
import static com.hr.jooq.tables.LeaveType.LEAVE_TYPE;
import com.hr.jooq.tables.pojos.LeaveType;
import java.io.IOException;
import java.util.List;
import org.infinispan.Cache;
import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface AbsenceDataApi {

    List<LeavesLeftBasic> getLeavesLeftByEmpId(int empId);

    List<LeavesAppliedBasic> getLeavesAppliedByEmpId(int empId);

    int applyLeave(ApplyLeaveInbound applyLeaveInfo);

    /*
     * Get leave types from cache. If they are not cached retrieve them directly
     * from db, and then cache them.
     */
    default List<LeaveType> getLeaveTypes() {
        Logger log = LoggerFactory.getLogger(AbsenceDataApi.class);
        ObjectMapper mapper = new ObjectMapper();
        Cache<String, Object> cache = ApplicationCacheFactory.getCache();
        Object get = cache.get(Constants.LEAVE_TYPE_KEY);
        if (get != null) {
            log.info("Returning cached result for getting leave_types. : {}", get);
            List<LeaveType> leaveTypesList = (List<LeaveType>) get;
            return leaveTypesList;
        }
        log.info("Leave types are not cached. Getting them directly from db..");
        try (MySQLConn conn = new MySQLConn()) {
            DSLContext create = conn.getDSLContext();
            List<LeaveType> leaveTypesList = create.select(LEAVE_TYPE.ID, LEAVE_TYPE.TYPE)
                    .from(LEAVE_TYPE)
                    .fetch().into(LeaveType.class);
            log.info("Caching leavetypes ..");
            cache.put(Constants.LEAVE_TYPE_KEY, leaveTypesList);
            return leaveTypesList;
        } catch (IOException | DataAccessException ex) {
            log.error("Error getting mysql conneciton or mapping error occured. Operation terminated. Exiting with null. Message : {}", ex.getMessage());
            return null;
        }
    }
}
