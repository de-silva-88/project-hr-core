package com.hr.data.dao.designation;

import com.hr.data.db.MySQLConn;
import static com.hr.jooq.tables.Designation.DESIGNATION;
import com.hr.jooq.tables.pojos.Designation;
import java.io.IOException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

@Slf4j
public class DesignationDataImpl implements DesignationDataApi{

    @Override
    public List<Designation> getDesignationList() {
        try (MySQLConn mysqlConn = new MySQLConn()) {
            DSLContext create = DSL.using(mysqlConn.getConnection(), SQLDialect.MYSQL);
            List<Designation> into = create.select(DESIGNATION.DESIGNATION_ID, DESIGNATION.DESIGNATION_NAME)
                    .from(DESIGNATION)
                    .where(DESIGNATION.IS_ACTIVE.eq(Byte.valueOf("1")))
                    .fetch().into(Designation.class);
            log.debug("designation list : {}", into);
            return into;
        } catch (IOException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null.");
            return null;
        }
    }
    
}
