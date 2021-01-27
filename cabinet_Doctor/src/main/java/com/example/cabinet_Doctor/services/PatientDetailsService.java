package com.example.cabinet_Doctor.services;

import com.example.cabinet_Doctor.models.Patient;

import java.util.List;

public interface PatientDetailsService {
    public List<Patient> getAll();
    public Patient findById(int id);
    public Patient save(Patient patient);
    public void deletePatient(int id);
    //public Patient updatePatient(int id, Patient patient);
}
