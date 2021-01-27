package com.example.cabinet_Doctor.services;

import com.example.cabinet_Doctor.models.Patient;
import com.example.cabinet_Doctor.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PatientService implements PatientDetailsService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> getAll() {
        List<Patient> list = new ArrayList<>();
        patientRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void deletePatient(int id) {

        patientRepository.deleteById(id);

    }

    @Override
    public Patient findById(int id) {
        return patientRepository.findById(id);

    }

//  @Override
//    public Patient updatePatient(int id, Patient patient) {
//       Patient updatePatient = patientRepository.findById(id);
//      updatePatient.setNom(patient.getNom());
//      updatePatient.setPrenom(patient.getPrenom());
//      updatePatient.setPassword(patient.getPassword());
//      updatePatient.setAdresse(patient.getAdresse());
//      updatePatient.setSexe(patient.getSexe());
//      updatePatient.setEmail(patient.getEmail());
//      updatePatient.setDateNaissance(patient.getDateNaissance());
//      updatePatient.setTel(patient.getTel());
//      updatePatient.setNumCNSS(patient.getNumCNSS());
//
//    Patient updatePatient = patientRepository.findById(patient.getId());
//
//      return patientRepository.save(updatePatient);
//   }
}



