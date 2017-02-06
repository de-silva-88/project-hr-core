package com.hr.data.dao.designation;

import com.hr.data.db.MySQLConn;
import com.hr.data.excetion.DataAccessException;
import static com.hr.jooq.tables.Designation.DESIGNATION;
import com.hr.jooq.tables.pojos.Designation;
import java.io.IOException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;

@Slf4j
public class DesignationDataImpl implements DesignationDataApi{

    @Override
    public List<Designation> getDesignationList() {
        try (MySQLConn mysqlConn = new MySQLConn()) {
            DSLContext create = mysqlConn.getDSLContext();
            List<Designation> into = create.select(DESIGNATION.DESIGNATION_ID, DESIGNATION.DESIGNATION_NAME)
                    .from(DESIGNATION)
                    .where(DESIGNATION.IS_ACTIVE.eq(Byte.valueOf("1")))
                    .fetch().into(Designation.class);
            log.debug("designation list : {}", into);
            return into;
        } catch (IOException | DataAccessException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null. Message : {}", ex.getMessage());
            return null;
        }
    }
    
}
