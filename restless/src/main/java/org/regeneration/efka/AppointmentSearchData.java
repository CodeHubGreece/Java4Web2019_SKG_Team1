package org.regeneration.efka;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Getter
@Setter
public class AppointmentSearchData {
    private int citizenId;
    private int doctorId;
    private Date fromDate;
    private Date toDate;
    private String description;
    private String notes;
    private int specialtyId;
}
