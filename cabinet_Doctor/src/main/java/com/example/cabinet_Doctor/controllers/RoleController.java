package com.example.cabinet_Doctor.controllers;

import com.example.cabinet_Doctor.models.Role;
import com.example.cabinet_Doctor.payload.responses.MessageResponse;
import com.example.cabinet_Doctor.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/roles")
public class RoleController {

    @Autowired
    RoleService roleService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/")
    public ResponseEntity<MessageResponse> addRole(@RequestBody Role role) {
        String message = this.roleService.addRole(role);
        return ResponseEntity.ok().body(new MessageResponse(message));
    }


//    @CrossOrigin(origins = "http://localhost:4200")
//    @GetMapping("/{id}")
//    public ResponseEntity<MessageResponse> affectRole(@RequestBody Role role) {
//        String message = this.roleService.affectRole(role);
//        return ResponseEntity.ok().body(new MessageResponse(message));
//    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public ResponseEntity<Role> getUserByID(@PathVariable(value="id") int id) {
        Role role = roleService.getRoleByID(id);
        if(role == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(role);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/{id}")
    public Role updateRoleByID(@PathVariable(value="id") int id, @RequestBody Role role) {
        return roleService.updateRoleByID(id, role);
    }
    
@CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRoleByID(@PathVariable(value="id") int user) {
        String message = roleService.deleteRoleByID(user);
        return ResponseEntity.ok().body(new MessageResponse(message));
    }

}