package com.hr.data.extrainfo;

import com.hr.data.db.MySQLConn;
import static com.hr.jooq.tables.AddressType.ADDRESS_TYPE;
import static com.hr.jooq.tables.BloodGroup.BLOOD_GROUP;
import static com.hr.jooq.tables.CivilStatus.CIVIL_STATUS;
import static com.hr.jooq.tables.ContactType.CONTACT_TYPE;
import static com.hr.jooq.tables.EduType.EDU_TYPE;
import static com.hr.jooq.tables.EmpType.EMP_TYPE;
import static com.hr.jooq.tables.Gender.GENDER;
import static com.hr.jooq.tables.Nationality.NATIONALITY;
import static com.hr.jooq.tables.Race.RACE;
import static com.hr.jooq.tables.Religion.RELIGION;
import static com.hr.jooq.tables.Title.TITLE;
import static com.hr.jooq.tables.WorkingType.WORKING_TYPE;
import com.hr.jooq.tables.pojos.AddressType;
import com.hr.jooq.tables.pojos.BloodGroup;
import com.hr.jooq.tables.pojos.CivilStatus;
import com.hr.jooq.tables.pojos.ContactType;
import com.hr.jooq.tables.pojos.EduType;
import com.hr.jooq.tables.pojos.EmpType;
import com.hr.jooq.tables.pojos.Gender;
import com.hr.jooq.tables.pojos.Nationality;
import com.hr.jooq.tables.pojos.Race;
import com.hr.jooq.tables.pojos.Religion;
import com.hr.jooq.tables.pojos.Title;
import com.hr.jooq.tables.pojos.WorkingType;
import java.io.IOException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

@Slf4j
public class ExtraInfoDataImpl implements ExtraInfoDataApi{

    @Override
    public List<Gender> getGenderList() {
        try (MySQLConn mysqlConn = new MySQLConn()) {
            DSLContext create = DSL.using(mysqlConn.getConnection(), SQLDialect.MYSQL);
            List<Gender> into = create.select(GENDER.GENDER_ID, GENDER.GENDER_NAME)
                    .from(GENDER)
                    .where(GENDER.IS_ACTIVE.eq(Byte.valueOf("1")))
                    .fetch().into(Gender.class);
            log.debug("Gender list : {}", into);
            return into;
        } catch (IOException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null.");
            return null;
        }
    }

    @Override
    public List<Title> getTitleList() {
        try (MySQLConn mysqlConn = new MySQLConn()) {
            DSLContext create = DSL.using(mysqlConn.getConnection(), SQLDialect.MYSQL);
            List<Title> into = create.select(TITLE.TITLE_ID, TITLE.TITLE_NAME)
                    .from(TITLE)
                    .where(TITLE.IS_ACTIVE.eq(Byte.valueOf("1")))
                    .fetch().into(Title.class);
            log.debug("Title list : {}", into);
            return into;
        } catch (IOException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null.");
            return null;
        }
    }

    @Override
    public List<BloodGroup> getBloodGroupList() {
        try (MySQLConn mysqlConn = new MySQLConn()) {
            DSLContext create = DSL.using(mysqlConn.getConnection(), SQLDialect.MYSQL);
            List<BloodGroup> into = create.select(BLOOD_GROUP.BLOOD_GROUP_ID, BLOOD_GROUP.BLOOD_GROUP_NAME)
                    .from(BLOOD_GROUP)
                    .where(BLOOD_GROUP.IS_ACTIVE.eq(Byte.valueOf("1")))
                    .fetch().into(BloodGroup.class);
            log.debug("Blood group list : {}", into);
            return into;
        } catch (IOException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null.");
            return null;
        }
    }

    @Override
    public List<Nationality> getNationalityList() {
        try (MySQLConn mysqlConn = new MySQLConn()) {
            DSLContext create = DSL.using(mysqlConn.getConnection(), SQLDialect.MYSQL);
            List<Nationality> into = create.select(NATIONALITY.NATIONALITY_ID, NATIONALITY.NATIONALITY_NAME)
                    .from(NATIONALITY)
                    .where(NATIONALITY.IS_ACTIVE.eq(Byte.valueOf("1")))
                    .fetch().into(Nationality.class);
            log.debug("Nationality list : {}", into);
            return into;
        } catch (IOException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null.");
            return null;
        }
    }

    @Override
    public List<Religion> getReligionList() {
        try (MySQLConn mysqlConn = new MySQLConn()) {
            DSLContext create = DSL.using(mysqlConn.getConnection(), SQLDialect.MYSQL);
            List<Religion> into = create.select(RELIGION.RELIGION_ID, RELIGION.RELIGION_NAME)
                    .from(RELIGION)
                    .where(RELIGION.IS_ACTIVE.eq(Byte.valueOf("1")))
                    .fetch().into(Religion.class);
            log.debug("Religion list : {}", into);
            return into;
        } catch (IOException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null.");
            return null;
        }
    }

    @Override
    public List<Race> getRaceList() {
        try (MySQLConn mysqlConn = new MySQLConn()) {
            DSLContext create = DSL.using(mysqlConn.getConnection(), SQLDialect.MYSQL);
            List<Race> into = create.select(RACE.RACE_ID, RACE.RACE_NAME)
                    .from(RACE)
                    .where(RACE.IS_ACTIVE.eq(Byte.valueOf("1")))
                    .fetch().into(Race.class);
            log.debug("Race list : {}", into);
            return into;
        } catch (IOException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null.");
            return null;
        }
    }

    @Override
    public List<CivilStatus> getCivilStatusList() {
        try (MySQLConn mysqlConn = new MySQLConn()) {
            DSLContext create = DSL.using(mysqlConn.getConnection(), SQLDialect.MYSQL);
            List<CivilStatus> into = create.select(CIVIL_STATUS.CIVIL_STATUS_ID, CIVIL_STATUS.CIVIL_STATUS_NAME)
                    .from(CIVIL_STATUS)
                    .where(CIVIL_STATUS.IS_ACTIVE.eq(Byte.valueOf("1")))
                    .fetch().into(CivilStatus.class);
            log.debug("CivilStatus list : {}", into);
            return into;
        } catch (IOException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null.");
            return null;
        }
    }

    @Override
    public List<AddressType> getAddressTypeList() {
        try (MySQLConn mysqlConn = new MySQLConn()) {
            DSLContext create = DSL.using(mysqlConn.getConnection(), SQLDialect.MYSQL);
            List<AddressType> into = create.select(ADDRESS_TYPE.ID, ADDRESS_TYPE.ADDR_TYPE)
                    .from(ADDRESS_TYPE)
                    .where(ADDRESS_TYPE.IS_ACTIVE.eq(Byte.valueOf("1")))
                    .fetch().into(AddressType.class);
            log.debug("AddressType list : {}", into);
            return into;
        } catch (IOException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null.");
            return null;
        }
    }

    @Override
    public List<ContactType> getContactTypeList() {
        try (MySQLConn mysqlConn = new MySQLConn()) {
            DSLContext create = DSL.using(mysqlConn.getConnection(), SQLDialect.MYSQL);
            List<ContactType> into = create.select(CONTACT_TYPE.ID, CONTACT_TYPE.CONT_TYPE)
                    .from(CONTACT_TYPE)
                    .where(CONTACT_TYPE.IS_ACTIVE.eq(Byte.valueOf("1")))
                    .fetch().into(ContactType.class);
            log.debug("ContactType list : {}", into);
            return into;
        } catch (IOException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null.");
            return null;
        }
    }

    @Override
    public List<EduType> getEduTypeList() {
        try (MySQLConn mysqlConn = new MySQLConn()) {
            DSLContext create = DSL.using(mysqlConn.getConnection(), SQLDialect.MYSQL);
            List<EduType> into = create.select(EDU_TYPE.ID, EDU_TYPE.EDU_TYPE_NAME)
                    .from(EDU_TYPE)
                    .where(EDU_TYPE.IS_ACTIVE.eq(Byte.valueOf("1")))
                    .fetch().into(EduType.class);
            log.debug("EduType list : {}", into);
            return into;
        } catch (IOException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null.");
            return null;
        }
    }

    @Override
    public List<EmpType> getEmpTypeList() {
        try (MySQLConn mysqlConn = new MySQLConn()) {
            DSLContext create = DSL.using(mysqlConn.getConnection(), SQLDialect.MYSQL);
            List<EmpType> into = create.select(EMP_TYPE.EMP_TYPE_ID, EMP_TYPE.EMP_TYPE_NAME)
                    .from(EMP_TYPE)
                    .where(EMP_TYPE.IS_ACTIVE.eq(Byte.valueOf("1")))
                    .fetch().into(EmpType.class);
            log.debug("EmpType list : {}", into);
            return into;
        } catch (IOException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null.");
            return null;
        }
    }

    @Override
    public List<WorkingType> getWorkingTypeList() {
        try (MySQLConn mysqlConn = new MySQLConn()) {
            DSLContext create = DSL.using(mysqlConn.getConnection(), SQLDialect.MYSQL);
            List<WorkingType> into = create.select(WORKING_TYPE.WORKING_TYPE_ID, WORKING_TYPE.WORKING_TYPE_NAME)
                    .from(WORKING_TYPE)
                    .where(WORKING_TYPE.IS_ACTIVE.eq(Byte.valueOf("1")))
                    .fetch().into(WorkingType.class);
            log.debug("WorkingType list : {}", into);
            return into;
        } catch (IOException ex) {
            log.error("Error getting mysql conneciton. Db operation terminated. Exiting with null.");
            return null;
        }
    }
    
}
