package com.example.cabinet_Doctor.repositories;

import com.example.cabinet_Doctor.models.ERole;
import com.example.cabinet_Doctor.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(ERole name);
}