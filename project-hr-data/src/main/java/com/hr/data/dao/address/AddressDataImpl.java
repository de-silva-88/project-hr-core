package com.hr.data.dao.address;

import com.hr.api.domain.AddressDetails;
import com.hr.data.db.MySQLConn;
import com.hr.data.excetion.DataAccessException;
import static com.hr.jooq.tables.Address.ADDRESS;
import static com.hr.jooq.tables.AddressType.ADDRESS_TYPE;
import java.io.IOException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;

@Slf4j
public class AddressDataImpl implements AddressDataApi{

    @Override
    public List<AddressDetails> getEmployeeAddress(int empNumber) {
        try (MySQLConn mysqlConn = new MySQLConn()) {
            DSLContext create = mysqlConn.getDSLContext();
            List<AddressDetails> into = create.select(ADDRESS.ID, ADDRESS.EMP_NUMBER, ADDRESS_TYPE.ADDR_TYPE.as("address_type"), 
                    ADDRESS.HOUSE_NO, ADDRESS.STREET, ADDRESS.CITY, ADDRESS.DISTRICT, ADDRESS.POSTAL_CODE)
                    .from(ADDRESS)
                    .leftOuterJoin(ADDRESS_TYPE)
                    .on(ADDRESS.TYPE_ID.eq(ADDRESS_TYPE.ID))
                    .where(ADDRESS.EMP_NUMBER.eq(empNumber)
                            .and(ADDRESS.IS_ACTIVE.eq(Byte.valueOf("1"))))
                    .fetch().into(AddressDetails.class);
            log.debug("Company list : {}", into);
            return into;
        } catch (IOException | DataAccessException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null. Message : {}", ex.getMessage());
            return null;
        }
    }
    
}
