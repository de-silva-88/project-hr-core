package com.hr.service.company;

import com.hr.service.dao.MySQLConn;
import com.hr.tables.pojos.Company;
import static com.hr.tables.Company.COMPANY;
import java.io.IOException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

@Slf4j
public class CompanyDAO {
    
    public List<Company> getCompanyList(){
        try (MySQLConn mysqlConn = new MySQLConn()) {
            DSLContext create = DSL.using(mysqlConn.getConnection(), SQLDialect.MYSQL);
            List<Company> into = create.select().from(COMPANY)
                    .where(COMPANY.IS_ACTIVE.eq(Byte.valueOf("1")))
                    .fetch().into(Company.class);
            log.info("Company list : {}", into);
            return into;
        } catch (IOException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null.");
            return null;
        }
    }
    
    public List<Company> getCompanyById(int id){
        try (MySQLConn mysqlConn = new MySQLConn()) {
            DSLContext create = DSL.using(mysqlConn.getConnection(), SQLDialect.MYSQL);
            List<Company> into = create.select().from(COMPANY)
                    .where(COMPANY.IS_ACTIVE.eq(Byte.valueOf("1"))
                            .and(COMPANY.COMPANY_ID.eq(id)))
                    .fetch().into(Company.class);
            log.info("Company id {} = {}",id, into);
            return into;
        } catch (IOException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null.");
            return null;
        }
    }
}
