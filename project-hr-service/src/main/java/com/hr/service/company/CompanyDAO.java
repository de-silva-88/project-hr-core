package com.hr.service.company;

import com.hr.service.dao.MySQLConn;
import com.hr.tables.pojos.Company;
import static com.hr.tables.Company.COMPANY;
import static com.hr.tables.Department.DEPARTMENT;
import static com.hr.tables.Section.SECTION;
import com.hr.tables.pojos.Department;
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
    
    public List<Company> getCompanyById(int id){
        try (MySQLConn mysqlConn = new MySQLConn()) {
            DSLContext create = DSL.using(mysqlConn.getConnection(), SQLDialect.MYSQL);
            List<Company> into = create.select(COMPANY.COMPANY_ID, COMPANY.COMPANY_NAME, COMPANY.DESCRIPTION)
                    .from(COMPANY)
                    .where(COMPANY.IS_ACTIVE.eq(Byte.valueOf("1"))
                            .and(COMPANY.COMPANY_ID.eq(id)))
                    .fetch().into(Company.class);
            log.debug("Company id = {} : {}",id, into);
            return into;
        } catch (IOException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null.");
            return null;
        }
    }
    
    public List<Department> getDepartmentList(){
        try (MySQLConn mysqlConn = new MySQLConn()) {
            DSLContext create = DSL.using(mysqlConn.getConnection(), SQLDialect.MYSQL);
            List<Department> into = create.select(DEPARTMENT.DEPARTMENT_ID, DEPARTMENT.DEPARTMENT_NAME, DEPARTMENT.DESCRIPTION)
                    .from(DEPARTMENT)
                    .where(DEPARTMENT.IS_ACTIVE.eq(Byte.valueOf("1")))
                    .fetch().into(Department.class);
            log.debug("Department list = {}", into);
            return into;
        } catch (IOException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null.");
            return null;
        }
    }
    
    public List<Department> getDepartmentById(int id){
        try (MySQLConn mysqlConn = new MySQLConn()) {
            DSLContext create = DSL.using(mysqlConn.getConnection(), SQLDialect.MYSQL);
            List<Department> into = create.select(DEPARTMENT.DEPARTMENT_ID, DEPARTMENT.DEPARTMENT_NAME, DEPARTMENT.DESCRIPTION)
                    .from(DEPARTMENT)
                    .where(DEPARTMENT.IS_ACTIVE.eq(Byte.valueOf("1"))
                            .and(DEPARTMENT.DEPARTMENT_ID.eq(id)))
                    .fetch().into(Department.class);
            log.debug("Department id = {} : {}",id, into);
            return into;
        } catch (IOException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null.");
            return null;
        }
    }
    
    public List<Department> getSectionList(){
        try (MySQLConn mysqlConn = new MySQLConn()) {
            DSLContext create = DSL.using(mysqlConn.getConnection(), SQLDialect.MYSQL);
            List<Department> into = create.select(SECTION.SECTION_ID, SECTION.SECTION_NAME, SECTION.DESCRIPTION)
                    .from(SECTION)
                    .where(SECTION.IS_ACTIVE.eq(Byte.valueOf("1")))
                    .fetch().into(Department.class);
            log.debug("Section list = {}", into);
            return into;
        } catch (IOException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null.");
            return null;
        }
    }
    
    public List<Department> getSectionById(int id){
        try (MySQLConn mysqlConn = new MySQLConn()) {
            DSLContext create = DSL.using(mysqlConn.getConnection(), SQLDialect.MYSQL);
            List<Department> into = create.select(SECTION.SECTION_ID, SECTION.SECTION_NAME, SECTION.DESCRIPTION)
                    .from(SECTION)
                    .where(SECTION.IS_ACTIVE.eq(Byte.valueOf("1"))
                            .and(SECTION.SECTION_ID.eq(id)))
                    .fetch().into(Department.class);
            log.debug("Section id = {} : {}", into);
            return into;
        } catch (IOException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null.");
            return null;
        }
    }
}
