package com.hr.data.dao.employee;

import com.hr.api.domain.EmployeePersonalDetails;
import com.hr.api.domain.EmployeeWork;
import com.hr.data.db.MySQLConn;
import static com.hr.jooq.Tables.COLLAR_SIZE;
import static com.hr.jooq.tables.BloodGroup.BLOOD_GROUP;
import static com.hr.jooq.tables.CivilStatus.CIVIL_STATUS;
import static com.hr.jooq.tables.Company.COMPANY;
import static com.hr.jooq.tables.Department.DEPARTMENT;
import static com.hr.jooq.tables.EmpType.EMP_TYPE;
import static com.hr.jooq.tables.EmpWork.EMP_WORK;

import static com.hr.jooq.tables.Employee.EMPLOYEE;
import static com.hr.jooq.tables.Gender.GENDER;
import static com.hr.jooq.tables.Location.LOCATION;
import static com.hr.jooq.tables.Nationality.NATIONALITY;
import static com.hr.jooq.tables.Race.RACE;
import static com.hr.jooq.tables.Religion.RELIGION;
import static com.hr.jooq.tables.Section.SECTION;
import static com.hr.jooq.tables.Title.TITLE;
import static com.hr.jooq.tables.TshirtSize.TSHIRT_SIZE;
import static com.hr.jooq.tables.WorkingType.WORKING_TYPE;
import com.hr.jooq.tables.pojos.Employee;
import java.io.IOException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

@Slf4j
public class EmployeeDataImpl implements EmployeeDataApi{

    @Override
    public List<Employee> getEmployeeList() {
        try (MySQLConn mysqlConn = new MySQLConn()) {
            DSLContext create = DSL.using(mysqlConn.getConnection(), SQLDialect.MYSQL);
            List<Employee> into = create.select(EMPLOYEE.ID, EMPLOYEE.FIRST_NAME, EMPLOYEE.LAST_NAME, EMPLOYEE.FULL_NAME)
                    .from(EMPLOYEE)
                    .where(EMPLOYEE.EMP_STATUS.eq(1))
                    .fetch().into(Employee.class);
            log.info("Employee list : {}", into);
            return into;
        } catch (IOException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null.");
            return null;
        }
    }

    @Override
    public List<EmployeePersonalDetails> getEmpPersonalDetailsById(int empId) {
        try (MySQLConn mysqlConn = new MySQLConn()) {
            DSLContext create = DSL.using(mysqlConn.getConnection(), SQLDialect.MYSQL);
            List<EmployeePersonalDetails> into = create.select(EMPLOYEE.ID, EMPLOYEE.CARD_NUMBER, GENDER.GENDER_NAME.as("gender"), 
                    TITLE.TITLE_NAME.as("title"), EMPLOYEE.INITIALS, EMPLOYEE.FIRST_NAME, EMPLOYEE.LAST_NAME, 
                    EMPLOYEE.FULL_NAME, EMPLOYEE.NIC_NAME, EMPLOYEE.DOB, EMPLOYEE.NIC, CIVIL_STATUS.CIVIL_STATUS_NAME.as("civil_status"), 
                    RELIGION.RELIGION_NAME.as("religion"), RACE.RACE_NAME.as("race"), NATIONALITY.NATIONALITY_NAME.as("nationality"), 
                    BLOOD_GROUP.BLOOD_GROUP_NAME.as("blood_group"), COLLAR_SIZE.SIZE.as("collar_size"), EMPLOYEE.PERSONAL_EMAIL,
                    TSHIRT_SIZE.SIZE.as("tshirt_Size"), EMPLOYEE.EMP_IMAGE )
                    .from(EMPLOYEE)
                    .leftOuterJoin(GENDER).on(EMPLOYEE.GENDER_ID.eq(GENDER.GENDER_ID))
                    .leftOuterJoin(TITLE).on(EMPLOYEE.TITLE_ID.eq(TITLE.TITLE_ID))
                    .leftOuterJoin(CIVIL_STATUS).on(EMPLOYEE.CIVIL_STATUS_ID.eq(CIVIL_STATUS.CIVIL_STATUS_ID))
                    .leftOuterJoin(RELIGION).on(EMPLOYEE.RELIGION_ID.eq(RELIGION.RELIGION_ID))
                    .leftOuterJoin(RACE).on(EMPLOYEE.RACE_ID.eq(EMPLOYEE.RACE_ID))
                    .leftOuterJoin(NATIONALITY).on(EMPLOYEE.NATIONALITY_ID.eq(NATIONALITY.NATIONALITY_ID))
                    .leftOuterJoin(BLOOD_GROUP).on(EMPLOYEE.BLOOD_GROUP.eq(BLOOD_GROUP.BLOOD_GROUP_ID))
                    .leftOuterJoin(COLLAR_SIZE).on(EMPLOYEE.COLLAR_SIZE_ID.eq(COLLAR_SIZE.ID))
                    .leftOuterJoin(TSHIRT_SIZE).on(EMPLOYEE.TSHIRT_SIZE_ID.eq(TSHIRT_SIZE.ID))
                    .where(EMPLOYEE.EMP_STATUS.eq(1)
                            .and(EMPLOYEE.ID.eq(empId)))
                    .fetch().into(EmployeePersonalDetails.class);
            log.info("Employee personal for emp id {} : {}", empId, into);
            return into;
        } catch (IOException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null.");
            return null;
        }
    }

    @Override
    public List<EmployeeWork> getEmpWorkDetailsById(int empId) {
        try (MySQLConn mysqlConn = new MySQLConn()) {
            DSLContext create = DSL.using(mysqlConn.getConnection(), SQLDialect.MYSQL);
            List<EmployeeWork> into = create.select(COMPANY.COMPANY_NAME.as("company"), DEPARTMENT.DEPARTMENT_NAME.as("department"), 
                    SECTION.SECTION_NAME.as("section"), LOCATION.LOCATION_NAME.as("location"), EMP_TYPE.EMP_TYPE_NAME.as("emp_type"), 
                    EMP_TYPE.EMP_TYPE_NAME.as("emp_type"), WORKING_TYPE.WORKING_TYPE_NAME.as("working_type"), 
                    EMP_WORK.APPOINTMENTDATE, EMP_WORK.PROBATION, EMP_WORK.PROBATION_DURATION, EMP_WORK.PROBATION_EXTENDED, 
                    EMP_WORK.PRO_EXTND_DURATION, EMP_WORK.OFFICE_EMAIL, EMP_WORK.DISTANCE_FROM_RESIDENCE, EMP_WORK.VEHICLE_ISSUED,
                    EMP_WORK.VEHICLE_TYPE, EMP_WORK.VEHICLE_NUMBER, EMP_WORK.VEHICLE_PASS_ISSUED, EMP_WORK.VEHICLE_PASS_NUMBER, 
                    EMP_WORK.OVERTIME, EMP_WORK.DESCRIPTION)
                    .from(EMP_WORK)
                    .leftOuterJoin(COMPANY).on(EMP_WORK.COMPANY_ID.eq(COMPANY.COMPANY_ID))
                    .leftOuterJoin(DEPARTMENT).on(EMP_WORK.DEPARTMENT_ID.eq(DEPARTMENT.DEPARTMENT_ID))
                    .leftOuterJoin(SECTION).on(EMP_WORK.SECTION_ID.eq(SECTION.SECTION_ID))
                    .leftOuterJoin(LOCATION).on(EMP_WORK.LOCATION_ID.eq(LOCATION.LOCATION_ID))
                    .leftOuterJoin(EMP_TYPE).on(EMP_WORK.EMP_TYPE_ID.eq(EMP_TYPE.EMP_TYPE_ID))
                    .leftOuterJoin(WORKING_TYPE).on(EMP_WORK.WORKING_TYPE_ID.eq(WORKING_TYPE.WORKING_TYPE_ID))
                    .where(EMP_WORK.EMP_NUMBER.eq(empId))
                    .fetch().into(EmployeeWork.class);
            log.info("Employee working details for emp id {} : {}", empId, into);
            return into;
        } catch (IOException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null.");
            return null;
        }
    }

}
