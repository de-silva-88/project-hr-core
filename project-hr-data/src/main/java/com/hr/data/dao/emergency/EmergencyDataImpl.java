package com.hr.data.dao.emergency;

import com.hr.api.domain.EmergencyContactDetails;
import com.hr.data.db.MySQLConn;
import static com.hr.jooq.tables.EmergencyContact.EMERGENCY_CONTACT;
import static com.hr.jooq.tables.RelationType.RELATION_TYPE;
import java.io.IOException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

@Slf4j
public class EmergencyDataImpl implements EmergencyDataApi{

    @Override
    public List<EmergencyContactDetails> getEmergencyConntact(int empNumber) {
         try (MySQLConn mysqlConn = new MySQLConn()) {
            DSLContext create = DSL.using(mysqlConn.getConnection(), SQLDialect.MYSQL);
             List<EmergencyContactDetails> into = create.select(EMERGENCY_CONTACT.ID, RELATION_TYPE.RELATION_TYPE_NAME.as("relation_type"), 
                     EMERGENCY_CONTACT.EMP_NUMBER, EMERGENCY_CONTACT.CONTACT_PERSON_NAME, EMERGENCY_CONTACT.PERSONAL_NUMBER, 
                     EMERGENCY_CONTACT.COMPANY_NAME, EMERGENCY_CONTACT.COMPANY_ADDRESS, EMERGENCY_CONTACT.OFFICE_NUMBER)
                     .from(EMERGENCY_CONTACT)
                     .leftOuterJoin(RELATION_TYPE)
                     .on(EMERGENCY_CONTACT.RELATION_TYPE_ID.eq(RELATION_TYPE.ID))
                     .where(EMERGENCY_CONTACT.EMP_NUMBER.eq(empNumber)
                             .and(EMERGENCY_CONTACT.IS_ACTIVE.eq(Byte.valueOf("1"))))
                     .fetch().into(EmergencyContactDetails.class);
            log.debug("emergency contact list for employee id {} : {}", empNumber , into);
            return into;
        } catch (IOException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null.");
            return null;
        }
    }
    
}
