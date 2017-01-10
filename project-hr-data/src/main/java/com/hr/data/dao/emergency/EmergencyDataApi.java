package com.hr.data.dao.emergency;

import com.hr.api.domain.EmergencyContactDetails;
import java.util.List;

public interface EmergencyDataApi {
   List<EmergencyContactDetails> getEmergencyConntact(int empNumber);
}
