package org.regeneration.rest.restless.controller;

import org.regeneration.rest.restless.entity.Appointment;
import org.regeneration.rest.restless.entity.Citizen;

import org.regeneration.rest.restless.repository.AppointmentRepository;
import org.regeneration.rest.restless.service.AppointmentService;
import org.regeneration.rest.restless.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class AppointmentController {


    private final AppointmentService appointmentService;
    private final CitizenService citizenService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService, CitizenService citizenService) {
        this.appointmentService = appointmentService;
        this.citizenService = citizenService;
    }
/*

    @GetMapping("/appointment/")
    public List<Appointment> getAppointments() {
        return appointmentService.findAll();
    }

    @GetMapping("/appointment/{id}")
    public Optional<Appointment> getAppointment(@PathVariable int id) {
        return appointmentService.findAppointmentsById(id);
    }
*/
/*
// gia delete mallon
    @GetMapping("/appointment/citizen")
    public List<Appointment> findAppointmentsByCitizen(Citizen citizen) {
        return appointmentService.findAppointmentsByCitizen(citizenService.findAppointmentsByCitizen());
    }
//gia delete mallon
    @GetMapping("/appointment/doctor")
    public List<Appointment> findAppointmentsByDoctor(Doctor doctor) {
        return appointmentService.findAppointmentsByDoctor(doctor.getAppointmentsById());
    }
*//*

    @GetMapping("/appointment/dates-specialty")
    public List<Appointment> findAppointmentsByDatesAndBySpecialty(@RequestParam(name = "startdate") String startDateString,
        @RequestParam(name = "enddate") String endDateString, @RequestParam(name = "specialtyId") int specialtyId) throws Exception {
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date startDate = format.parse(startDateString);
        Date endDate = format.parse(endDateString);
        return appointmentService.findAppointmentsByDatesAndBySpecialty(startDate, endDate, specialtyId);
    }


    @GetMapping("/appointment/dates-doctor")
    public List<Appointment> findAppointmentsByDatesAndByDescription(@RequestParam(name = "startdate") String startDateString,
        @RequestParam(name = "enddate") String endDateString, @RequestParam(name = "description") String description) throws Exception {
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date startDate = format.parse(startDateString);
        Date endDate = format.parse(endDateString);
        return appointmentService.findAppointmentsByDatesAndByDescription(startDate, endDate, description);
    }




    @PostMapping("/appointment/{id}")
    public Appointment createNewAppointment(*/
/*@PathVariable int id,*//*
 @RequestBody Appointment newAppointment) {
       // Citizen citizen= citizenService.findById(id);
       // newAppointment.setCitizenId(id);
        return appointmentService.createAppointment(newAppointment);
    }

*/

}