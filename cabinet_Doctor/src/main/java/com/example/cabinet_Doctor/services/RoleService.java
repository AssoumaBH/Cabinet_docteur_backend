package com.example.cabinet_Doctor.services;

import com.example.cabinet_Doctor.models.Role;
import com.example.cabinet_Doctor.repositories.PatientRepository;
import com.example.cabinet_Doctor.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoleService implements RoleDetailsService{
    @Autowired
    RoleRepository roleRepository;
    PatientRepository patientRepository;

    @Override
    public String addRole(Role role) {
        roleRepository.save(role);
        return "Role added successfully";
    }

//    @Override
//    public String affectRole(Role role) {
//
//        Role newRole = new Role();
//        newRole.setName(role.getName());
//        newRole.setPatients(role.getPatients());
//        Role savedRole = roleRepository.save(newRole);
//        if (roleRepository.findById(savedRole.getId()).isPresent()) {
//            return "Successfully Created Role and Users";
//        } else
//            return "Failed to Create specified Role";
//    }
    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
    @Override
    public Role getRoleByID(int id) {
        return roleRepository.findById(id).get();
    }

     @Override
    public Role updateRoleByID(int id, Role role) {
        Role existingRole = roleRepository.findById(id).orElse(null);
        if(existingRole != null)
        {
            existingRole.setName(role.getName());
        }
        return roleRepository.save(existingRole);
    }

     @Override
    public String deleteRoleByID(int id) {
        Optional<Role> existingRole = roleRepository.findById(id);
        if(existingRole.isPresent()) {
            roleRepository.delete(existingRole.get());
            return "Role is deleted by id "+ id;
        }
        throw new RuntimeException("Role not found .");
    }

}