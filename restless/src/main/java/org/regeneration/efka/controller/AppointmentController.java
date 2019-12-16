package org.regeneration.efka.controller;

import org.regeneration.efka.NewAppointmentData;
import org.regeneration.efka.entity.Appointment;
import org.regeneration.efka.entity.Doctor;
import org.regeneration.efka.service.AppointmentService;
import org.regeneration.efka.service.CitizenService;
import org.regeneration.efka.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.sql.Timestamp;
import java.util.List;

@RestController
public class AppointmentController {


    private final AppointmentService appointmentService;
    private final CitizenService citizenService;


    @Autowired
    public AppointmentController(AppointmentService appointmentService, CitizenService citizenService) {
        this.appointmentService = appointmentService;
        this.citizenService = citizenService;

    }


    @GetMapping("/appointments")
    public List<Appointment> findAll() {
        return appointmentService.findAll();
    }

    @GetMapping("/appointment/{id}")
    public Appointment findById(@PathVariable int id) {
        return appointmentService.findById(id);
    }



    /*@GetMapping("/appointment/citizen")
    public List<Appointment> findAppointmentsByCitizen(Citizen citizen) {
        return appointmentService.findAppointmentsByCitizen(citizenService.findAppointmentsByCitizen());
    }

    @GetMapping("/appointment/doctor")
    public List<Appointment> findAppointmentsByDoctor(Doctor doctor) {
        return appointmentService.findAppointmentsByDoctor(doctor.getAppointmentsById());
    }*/


    //αλαξα ολα τα απο κατω

    @GetMapping("/appointment/dates-doctor")
    public List<Appointment> findAllByDatetimeBetweenAndSpecialty(@RequestParam(name = "fromDate") String fromDateString,
                                                                 @RequestParam(name = "toDate") String toDateString,
                                                                 @RequestParam(name = "specialtyId") int specialtyId) {


        Timestamp fromDate = Timestamp.valueOf(fromDateString + " 00:00:00");
        Timestamp toDate = Timestamp.valueOf(toDateString + " 00:00:00");
        System.out.print((fromDate));
        return appointmentService.findAllByDatetimeBetweenAndSpecialtyId(fromDate, toDate, specialtyId);//prepei na psaxnei kai me to citizen id.
       // return null;


    }


    @GetMapping("/appointment/dates-description")
    public List<Appointment> findAllByDatetimeBetweenAndDescription(@RequestParam(name = "fromDate") String fromDateString,
                                                                    @RequestParam(name = "toDate") String toDateString,
                                                                    @RequestParam(name = "description") String description) {
        Timestamp fromDate = Timestamp.valueOf(fromDateString + " 00:00:00");
        Timestamp toDate = Timestamp.valueOf(toDateString + " 00:00:00");
        return appointmentService.findAllByDatetimeBetweenAndDescription(fromDate, toDate, description);
    }


    @PostMapping("/appointment/new")
        public Appointment newAppointment(@RequestBody NewAppointmentData newAppointmentData) {
        return appointmentService.createAppointment(newAppointmentData);
    }


}