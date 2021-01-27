package com.example.cabinet_Doctor.repositories;

import com.example.cabinet_Doctor.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

  Reservation findById(int id);
}