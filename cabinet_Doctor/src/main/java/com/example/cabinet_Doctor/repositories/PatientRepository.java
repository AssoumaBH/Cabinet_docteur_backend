package com.example.cabinet_Doctor.repositories;

import com.example.cabinet_Doctor.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
@Repository
@RepositoryRestResource(path = "patients")
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    Patient findById(int id);
}
