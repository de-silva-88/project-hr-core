package com.hr.service.application;

import com.hr.service.absence.AbsenceResource;
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
        return resourceClasses;
    }
}
