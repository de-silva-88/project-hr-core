package com.hr.data.extrainfo;

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
import java.util.List;

public interface ExtraInfoDataApi {
    List<Gender> getGenderList();
    List<Title> getTitleList();
    List<BloodGroup> getBloodGroupList();
    List<Nationality> getNationalityList();
    List<Religion> getReligionList();
    List<Race> getRaceList();
    List<CivilStatus> getCivilStatusList();
    List<AddressType> getAddressTypeList();
    List<ContactType> getContactTypeList();
    List<EduType> getEduTypeList();
    List<EmpType> getEmpTypeList();
    List<WorkingType> getWorkingTypeList();
}
