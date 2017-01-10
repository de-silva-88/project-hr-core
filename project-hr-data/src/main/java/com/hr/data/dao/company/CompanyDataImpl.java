package com.hr.data.dao.company;

import com.hr.data.db.MySQLConn;
import static com.hr.jooq.tables.Company.COMPANY;
import com.hr.jooq.tables.pojos.Company;
import java.io.IOException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

@Slf4j
public class CompanyDataImpl implements CompanyDataApi{

    @Override
    public List<Company> getCompanyList() {
        try (MySQLConn mysqlConn = new MySQLConn()) {
            DSLContext create = DSL.using(mysqlConn.getConnection(), SQLDialect.MYSQL);
            List<Company> into = create.select(COMPANY.COMPANY_ID, COMPANY.COMPANY_NAME, COMPANY.DESCRIPTION)
                    .from(COMPANY)
                    .where(COMPANY.IS_ACTIVE.eq(Byte.valueOf("1")))
                    .fetch().into(Company.class);
            log.debug("Company list : {}", into);
            return into;
        } catch (IOException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null.");
            return null;
        }
    }

    @Override
    public List<Company> getCompanyById(int companyId) {
        try (MySQLConn mysqlConn = new MySQLConn()) {
            DSLContext create = DSL.using(mysqlConn.getConnection(), SQLDialect.MYSQL);
            List<Company> into = create.select(COMPANY.COMPANY_ID, COMPANY.COMPANY_NAME, COMPANY.DESCRIPTION)
                    .from(COMPANY)
                    .where(COMPANY.IS_ACTIVE.eq(Byte.valueOf("1"))
                            .and(COMPANY.COMPANY_ID.eq(companyId)))
                    .fetch().into(Company.class);
            log.debug("Company id = {} : {}",companyId , into);
            return into;
        } catch (IOException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null.");
            return null;
        }
    }
    
}
