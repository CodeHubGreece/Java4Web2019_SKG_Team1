package org.regeneration.efka;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Component
@Getter
@Setter
public class AppointmentData {
    private int id;
    private int citizenId;
    private int doctorId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    private String description;
    private String notes;
}
