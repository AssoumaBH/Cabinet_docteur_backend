package com.example.cabinet_Doctor.services;

import com.example.cabinet_Doctor.models.Reservation;
import com.example.cabinet_Doctor.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReservationService implements ReservationDetailsService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public List<Reservation> getAll() {
        List<Reservation> list  = reservationRepository.findAll();
        return list;
    }

    @Override
    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteRDV(int id) {

        reservationRepository.deleteById(id);

    }

    @Override
    public Reservation findById(int id) {
        return reservationRepository.findById(id);

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



