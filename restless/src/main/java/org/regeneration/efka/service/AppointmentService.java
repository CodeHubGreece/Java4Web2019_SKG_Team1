package org.regeneration.efka.service;


import org.regeneration.efka.NewAppointmentData;
import org.regeneration.efka.entity.Appointment;
import org.regeneration.efka.entity.Doctor;
import org.regeneration.efka.repository.AppointmentRepository;
import org.regeneration.efka.repository.CitizenRepository;
import org.regeneration.efka.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final CitizenRepository  citizenRepository;
    private final DoctorRepository doctorRepository;



    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, CitizenRepository citizenRepository, DoctorRepository doctorRepository) {
        this.appointmentRepository = appointmentRepository;
        this.citizenRepository = citizenRepository;
        this.doctorRepository = doctorRepository;
    }

    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    public Appointment findById(int id) {
        return appointmentRepository.findById(id);
    }



    //ALEX CHANGED THIS
    public List<Appointment> findAllByDatetimeBetweenAndSpecialtyId(Timestamp fromDate, Timestamp toDate, int specialtyId) {

       List<Doctor> doctorList = doctorRepository.findAllBySpecialityId(specialtyId);
       List appointments = new ArrayList();

       System.out.print(doctorList);

        for (Doctor doctor : doctorList) {
           appointments.add( appointmentRepository.findAllByDatetimeBetweenAndDoctorId(fromDate, toDate, doctor.getId()));
            System.out.print("pass");
        }


        return appointments;
    }




    public List<Appointment> findAllByDatetimeBetweenAndDescription(Timestamp fromDate, Timestamp toDate, String description) {
        return appointmentRepository.findAllByDatetimeBetweenAndDescription(fromDate, toDate, description);

    }
    //ALEX CHANGED THIS
    public Appointment createAppointment(NewAppointmentData newAppointmentData) {
        Appointment newAppointment = new Appointment();
        newAppointment.setCitizenId(newAppointmentData.getCitizenId());
        newAppointment.setDatetime(newAppointmentData.getDatetime());
        newAppointment.setDoctorId(newAppointmentData.getDoctorId());
        newAppointment.setDescription(newAppointmentData.getDescription());
        newAppointment.setNotes(newAppointmentData.getNotes());
        newAppointment.setCitizen(citizenRepository.findById(newAppointmentData.getCitizenId()));
        newAppointment.setDoctor(doctorRepository.findById(newAppointmentData.getDoctorId()));

        System.out.print(newAppointment);

        return appointmentRepository.save(newAppointment);
    }
}
