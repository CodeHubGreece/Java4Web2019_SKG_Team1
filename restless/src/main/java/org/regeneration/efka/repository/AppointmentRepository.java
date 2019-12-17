package org.regeneration.efka.repository;

import org.regeneration.efka.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    List<Appointment> findAllByDescription(String description);

    List<Appointment> findAllByDoctorId(int doctorId);

    List<Appointment> findAllByDatetimeBetweenAndDoctorId(Date fromDate, Date toDate, int doctorId);

    List<Appointment> findAllByDoctorIdAndDatetimeBetweenAndDescriptionContainsOrderByDatetimeAsc(int doctorId, Date fromDate, Date toDate, String description);

    Appointment findById(int id);

    void deleteById(int id);

    boolean existsByCitizenIdAndDatetime(int citizenId, Date datetime);
    boolean existsByDoctorIdAndDatetime(int doctorId, Date datetime);
}
