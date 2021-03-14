package com.example.cabinet_Doctor.services;

import com.example.cabinet_Doctor.exceptions.EmailAlreadyUsedException;
import com.example.cabinet_Doctor.exceptions.ResourceNotFoundException;
import com.example.cabinet_Doctor.models.ERole;
import com.example.cabinet_Doctor.models.Patient;
import com.example.cabinet_Doctor.models.Role;
import com.example.cabinet_Doctor.payload.requests.LoginRequest;
import com.example.cabinet_Doctor.payload.requests.RegisterRequest;
import com.example.cabinet_Doctor.repositories.PatientRepository;
import com.example.cabinet_Doctor.repositories.RoleRepository;
import com.example.cabinet_Doctor.security.jwt.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenUtils jwtTokenUtils;

    public String login(LoginRequest loginRequest)
    {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return this.jwtTokenUtils.generateToken(userDetails);
    }


    public String register(RegisterRequest registerRequest) throws EmailAlreadyUsedException {
        // test if email already used
        if (this.patientRepository.existsByEmail(registerRequest.getEmail())) {
            throw new EmailAlreadyUsedException("Error: Email is already in use!");
        }
        // Create new user account
        Patient patient = new Patient();
        patient.setNom(registerRequest.getNom());
        patient.setAdresse(registerRequest.getAdresse());
        patient.setSexe(registerRequest.getSexe());
        patient.setPrenom(registerRequest.getPrenom());
        patient.setDateNaissance(registerRequest.getDateNaissance());
        patient.setTel(registerRequest.getTel());
        patient.setNumCNSS(registerRequest.getNumCNSS());
        patient.setEmail(registerRequest.getEmail());
        patient.setPassword (passwordEncoder.encode(registerRequest.getPassword()));
        // Traitement des Roles
        Set<String> registerRequestRoles = registerRequest.getRoles();
        Set<Role> roles = new HashSet<>();

        // find Roles
        if (registerRequestRoles == null) {
            Role admin = this.roleRepository.findByName(ERole.ROLE_ADMIN)
                    .orElseThrow(() -> new ResourceNotFoundException("Error: Role is not found."));
            roles.add(admin);
        } else {
                        Role user = this.roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new ResourceNotFoundException("Error: Role is not found."));
                        roles.add(user);
        }

        // Affect User Roles
        patient.setRoles(roles);
        this.patientRepository.save(patient);
        return "Patient registered successfully!";
    }
}
