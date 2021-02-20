package com.example.cabinet_Doctor.controllers;

import com.example.cabinet_Doctor.models.Patient;
import com.example.cabinet_Doctor.models.Role;
import com.example.cabinet_Doctor.services.PatientDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Access;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
//@CrossOrigin(origins="http://localhost:4200/register")

@RestController
public class PatientController {

    @Autowired
    private PatientDetailsService patientService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping( "/patients/{id}")
    public Patient getOne(@PathVariable(value = "id") int id){
        return patientService.findById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/patients")
    public List<Patient> listPatient(){
        return patientService.getAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/patients")
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        try {
            Patient createdPatient = patientService.savep(patient);
            return new ResponseEntity<Patient>(createdPatient, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/patients/{id}")
//    public ResponseEntity<Patient> updatePatient(@PathVariable("id") int id, @RequestBody Patient patient) {
//        patient = patientService.findById(id);
//      //  patient.getPatients();
//       patient = patientService.updatePatient(id,patient);
//
//        return new ResponseEntity<>(patient, HttpStatus.OK);
//    }


    public Patient updatePatient(@PathVariable(value="id") int id, @RequestBody Patient patient) {
        return patientService.updatePatient(id, patient);
    }

@CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/patients/{id}")
    public ResponseEntity<HttpStatus> deletePatient(@PathVariable("id") int id) {
        System.out.println(id);
        patientService.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.OK); //"student has been deleted successfully";
    }


}