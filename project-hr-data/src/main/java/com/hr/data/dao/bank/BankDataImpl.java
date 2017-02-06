package com.hr.data.dao.bank;

import com.hr.api.domain.BankData;
import com.hr.data.db.MySQLConn;
import com.hr.data.excetion.DataAccessException;
import static com.hr.jooq.tables.Bank.BANK;
import static com.hr.jooq.tables.BankDetails.BANK_DETAILS;
import java.io.IOException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

@Slf4j
public class BankDataImpl implements BankDataApi{

    @Override
    public List<BankData> getEmployeeBankData(int empNumber) {
        try (MySQLConn mysqlConn = new MySQLConn()) {
            DSLContext create = mysqlConn.getDSLContext();
            List<BankData> into = create.select(BANK.BANK_NAME, BANK_DETAILS.BANK_CODE, BANK_DETAILS.BRANCH_CODE)
                    .from(BANK_DETAILS)
                    .leftOuterJoin(BANK).on(BANK_DETAILS.BANK_ID.eq(BANK.ID))
                    .where(BANK_DETAILS.EMP_NUMBER.eq(empNumber))
                    .fetch().into(BankData.class);
            log.info("Employee bank details for emp id {} : {}", empNumber, into);
            return into;
        } catch (IOException | DataAccessException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null. Message : {}", ex.getMessage());
            return null;
        }
    }
    
}
