package com.example.cabinet_Doctor.payload.requests;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;
@Data
public class RegisterRequest {

    @NotBlank
    @Size(min = 3, max = 20)
    private String nom;

    @NotBlank
    @Size(min = 3, max = 20)
    private String prenom;


    private int tel;

    @NotBlank
    @Size(min = 3, max = 20)
    private String sexe;

    @NotBlank
    @Size(min = 3, max = 20)
    private String adresse;

    @NotBlank
    @Size(min = 3, max = 20)
    private String numCNSS;

    @NotBlank
    @Size(min = 3, max = 20)
    private String dateNaissance;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    private Set<String> roles;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;


}