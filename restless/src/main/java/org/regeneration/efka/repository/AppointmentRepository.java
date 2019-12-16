package org.regeneration.efka.repository;

import org.regeneration.efka.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    List<Appointment> findAllByDescription(String description);

    List<Appointment> findAllByDoctorId(int doctorId);

    List<Appointment> findAllByDatetimeBetweenAndDoctorId(Timestamp fromDate, Timestamp toDate, int doctorId);

    List<Appointment> findAllByDatetimeBetweenAndDescription(Timestamp fromDate, Timestamp toDate, String description);

    Appointment findById(int id);
}
