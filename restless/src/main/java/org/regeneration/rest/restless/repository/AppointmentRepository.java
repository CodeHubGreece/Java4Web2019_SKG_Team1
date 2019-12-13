package org.regeneration.rest.restless.repository;

import org.regeneration.rest.restless.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {


  //  List<Appointment> findAppointmentsBetweenDates(Date startDate, Date endDate);

  //  List<Appointment> findAppointmentsBySpecialty(int specialtyId);

    List<Appointment> findAppointmentsByDescription(String description);
}
