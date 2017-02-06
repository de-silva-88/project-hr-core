package com.hr.data.dao.company;

import com.hr.data.db.MySQLConn;
import com.hr.data.excetion.DataAccessException;
import static com.hr.jooq.tables.Company.COMPANY;
import com.hr.jooq.tables.pojos.Company;
import java.io.IOException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;

@Slf4j
public class CompanyDataImpl implements CompanyDataApi{

    @Override
    public List<Company> getCompanyList() {
        try (MySQLConn mysqlConn = new MySQLConn()) {
            DSLContext create = mysqlConn.getDSLContext();
            List<Company> into = create.select(COMPANY.COMPANY_ID, COMPANY.COMPANY_NAME, COMPANY.DESCRIPTION)
                    .from(COMPANY)
                    .where(COMPANY.IS_ACTIVE.eq(Byte.valueOf("1")))
                    .fetch().into(Company.class);
            log.debug("Company list : {}", into);
            return into;
        } catch (IOException | DataAccessException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null. Message : {}", ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Company> getCompanyById(int companyId) {
        try (MySQLConn mysqlConn = new MySQLConn()) {
            DSLContext create = mysqlConn.getDSLContext();
            List<Company> into = create.select(COMPANY.COMPANY_ID, COMPANY.COMPANY_NAME, COMPANY.DESCRIPTION)
                    .from(COMPANY)
                    .where(COMPANY.IS_ACTIVE.eq(Byte.valueOf("1"))
                            .and(COMPANY.COMPANY_ID.eq(companyId)))
                    .fetch().into(Company.class);
            log.debug("Company id = {} : {}",companyId , into);
            return into;
        } catch (IOException | DataAccessException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null. Message : {}", ex.getMessage());
            return null;
        }
    }
    
}
