package com.hr.service.application;

import com.hr.service.absence.AbsenceResource;
import com.hr.service.company.CompanyResource;
import com.hr.service.employee.EmployeeResource;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest/*")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resourceClasses = new HashSet<>();
        resourceClasses.add(AbsenceResource.class);
        resourceClasses.add(CompanyResource.class);
        resourceClasses.add(EmployeeResource.class);
        return resourceClasses;
    }
}
