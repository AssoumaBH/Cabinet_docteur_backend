package com.example.cabinet_Doctor.services;

import com.example.cabinet_Doctor.models.ERole;
import com.example.cabinet_Doctor.models.Patient;

import com.example.cabinet_Doctor.models.Role;
import com.example.cabinet_Doctor.repositories.PatientRepository;
import com.example.cabinet_Doctor.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PatientService implements PatientDetailsService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override

    public List<Patient> getAll() {
        List<Patient> list = new ArrayList<>();
        patientRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Patient savep(Patient patient) {
        // affect role user
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(userRole);
        patient.setRoles(roles);
        // save patient
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
//


  @Override
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
//      updatePatient.setnumCNSS(patient.getnumCNSS());
//
//
//      return patientRepository.save(updatePatient);
//   }

    public Patient updatePatient(int id, Patient patient) {
        Patient existingPatient = patientRepository.findById(id);
        if(existingPatient != null)
        {
            existingPatient.setNom(patient.getNom());
            existingPatient.setPrenom(patient.getPrenom());
            existingPatient.setPassword(patient.getPassword());
            existingPatient.setAdresse(patient.getAdresse());
            existingPatient.setSexe(patient.getSexe());
            existingPatient.setEmail(patient.getEmail());
            existingPatient.setDateNaissance(patient.getDateNaissance());
            existingPatient.setTel(patient.getTel());
            existingPatient.setnumCNSS(patient.getnumCNSS());

        }
        return patientRepository.save(existingPatient);
    }
}



