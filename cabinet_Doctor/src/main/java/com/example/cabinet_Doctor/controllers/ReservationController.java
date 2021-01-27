package com.example.cabinet_Doctor.controllers;

import com.example.cabinet_Doctor.models.Patient;
import com.example.cabinet_Doctor.models.Reservation;
import com.example.cabinet_Doctor.services.ReservationDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ReservationController {

    @Autowired
private ReservationDetailsService reservationService;


    @GetMapping( "/reservation/{id}")
    public Reservation getOne(@PathVariable(value = "id") int id){
        return reservationService.findById(id);
    }


    @GetMapping(value="/reservation")
    public List<Reservation> listReservation(){
        return reservationService.getAll();
    }

    @PostMapping("/reservation")
    public ResponseEntity<Reservation> createdReservation(@RequestBody Reservation reservation) {
        try {
            Reservation createdReservation = reservationService.save(reservation);
            return new ResponseEntity<Reservation>(createdReservation, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PutMapping("/patients/{id}")
//    public ResponseEntity<Patient> updatePatient(@PathVariable("id") int id, @RequestBody Patient patient) {
//        Patient patient = patientService.findById(id);
//        patient.getPatients();
//       patient = patientService.updatePatient(id,patient);
//
//        return new ResponseEntity<>(patient, HttpStatus.OK);
//    }

    @DeleteMapping("/reservation/{id}")
    public ResponseEntity<HttpStatus> deleteRDV(@PathVariable("id") int id) {
        System.out.println(id);
        reservationService.deleteRDV(id);
        return new ResponseEntity<>(HttpStatus.OK); //"student has been deleted successfully";
    }


}