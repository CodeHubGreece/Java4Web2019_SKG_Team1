package org.regeneration.efka;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
@Getter
@Setter
public class NewAppointmentData {
    private int citizenId;
    private int doctorId;
    private Timestamp datetime;
    private String description;
    private String notes;
}
