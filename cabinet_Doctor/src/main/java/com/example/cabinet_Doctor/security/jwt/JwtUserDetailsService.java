package com.example.cabinet_Doctor.security.jwt;


import com.example.cabinet_Doctor.models.Patient;
import com.example.cabinet_Doctor.models.Role;
import com.example.cabinet_Doctor.services.PatientDetailsService;
import com.example.cabinet_Doctor.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private PatientService patientService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        if (email.trim().isEmpty()) {
            throw new UsernameNotFoundException("username is empty");
        }

        Patient patient = patientService.findByEmail(email);

        if (patient == null) {
            throw new UsernameNotFoundException("User with email = " + email + " not found");
        }

        return new org.springframework.security.core.userdetails.User(patient.getEmail(), patient.getPassword(), getGrantedAuthorities(patient));
    }

    private List<GrantedAuthority> getGrantedAuthorities(Patient patient) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        Set<Role> roles = patient.getRoles();
        roles.forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName().name()));
        });
        return authorities;
    }
}