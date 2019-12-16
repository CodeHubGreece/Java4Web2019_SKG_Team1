package org.regeneration.efka;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Getter
@Setter
public class NewAppointmentData {
    private int citizenId;
    private int doctorId;
    private Date datetime;
    private String description;
    private String notes;
}
