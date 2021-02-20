package com.example.cabinet_Doctor.services;

import com.example.cabinet_Doctor.models.Patient;
import com.example.cabinet_Doctor.models.Role;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RoleDetailsService {
    public List<Role> getAllRoles();
    public String addRole(Role role);
//    public String affectRole(Role role);
    public Role getRoleByID(int id);
    public String deleteRoleByID(int id);
    public Role updateRoleByID(int id, Role role);
}
