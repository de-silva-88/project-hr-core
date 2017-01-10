package com.hr.service.extrainfo;

import com.hr.data.dao.DataFactory;
import com.hr.data.extrainfo.ExtraInfoDataApi;
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
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExtraInfoModel {
    private ExtraInfoDataApi extraInfoDataApi;
    {extraInfoDataApi = DataFactory.getInstanceExtraInfoDataAPI();}
    
    public List<Gender> getGenderList(){
        List<Gender> genderList = extraInfoDataApi.getGenderList();
        log.info("gender list : {}", genderList);
        return genderList;
    }
    
    public List<Title> getTitleList(){
        List<Title> titleList = extraInfoDataApi.getTitleList();
        log.info("title list : {} ", titleList);
        return titleList;
    }
    
    public List<BloodGroup> getBloodGroupList(){
        List<BloodGroup> bloodGroupList = extraInfoDataApi.getBloodGroupList();
        log.info("blood group list : {}", bloodGroupList);
        return bloodGroupList;
    }
    
    public List<Nationality> getNationalityList(){
        List<Nationality> nationalityList = extraInfoDataApi.getNationalityList();
        log.info("nationality list : {}", nationalityList);
        return nationalityList;
    }
    
    public List<Religion> getReligionList(){
        List<Religion> religionList = extraInfoDataApi.getReligionList();
        log.info("religion list : {}", religionList);
        return religionList;
    }
    
    public List<Race> getRaceList(){
        List<Race> raceList = extraInfoDataApi.getRaceList();
        log.info("race list : {}", raceList);
        return raceList;
    }
    
    public List<CivilStatus> getCivilStatusList(){
        List<CivilStatus> civilStatus = extraInfoDataApi.getCivilStatusList();
        log.info("civil status : {}", civilStatus);
        return civilStatus;
    }
    
    public List<AddressType> getAddressTypeList(){
        List<AddressType> addressTypeList = extraInfoDataApi.getAddressTypeList();
        log.info("address type list : {}", addressTypeList);
        return addressTypeList;
    }
    
    public List<ContactType> getContactTypeList(){
        List<ContactType> contactTypeList = extraInfoDataApi.getContactTypeList();
        log.info("contact type list : {}", contactTypeList);
        return contactTypeList;
    }
    
    public List<EduType> getEduTypeList(){
        List<EduType> eduTypeList = extraInfoDataApi.getEduTypeList();
        log.info("edu type list : {}", eduTypeList);
        return eduTypeList;
    }
    
    public List<EmpType> getEmpTypeList(){
        List<EmpType> empTypeList = extraInfoDataApi.getEmpTypeList();
        log.info("emp type list : {}", empTypeList);
        return empTypeList;
    }
    
    public List<WorkingType> getWorkingTypeList(){
        List<WorkingType> workingType = extraInfoDataApi.getWorkingTypeList();
        log.info("working type list : {}", workingType);
        return workingType;
    }
}
