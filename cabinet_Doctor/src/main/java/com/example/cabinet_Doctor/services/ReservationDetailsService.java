package com.example.cabinet_Doctor.services;

import com.example.cabinet_Doctor.models.Patient;
import com.example.cabinet_Doctor.models.Reservation;

import java.util.List;

public interface ReservationDetailsService {
    public List<Reservation> getAll();
    public Reservation findById(int id);
    public Reservation save(Reservation reservation);
    public void deleteRDV(int id);

}
