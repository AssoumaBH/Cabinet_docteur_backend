package com.example.cabinet_Doctor;

import com.example.cabinet_Doctor.models.ERole;
import com.example.cabinet_Doctor.models.Patient;
import com.example.cabinet_Doctor.models.Role;
import com.example.cabinet_Doctor.repositories.PatientRepository;
import com.example.cabinet_Doctor.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class CabinetDoctorApplication implements ApplicationRunner {
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	PatientRepository patientRepository;
	public static void main(String[] args) {
		SpringApplication.run(CabinetDoctorApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedMethods("GET", "POST");
			}
		};
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		this.roleRepository.deleteAllInBatch();
		this.patientRepository.deleteAllInBatch();
		Role admin = new Role();
		admin.setName(ERole.ROLE_ADMIN);
		this.roleRepository.save(admin);
		Role user = new Role();
		user.setName(ERole.ROLE_USER);
		this.roleRepository.save(user);

		Patient Pas_admin =new Patient();
		Pas_admin.setNom("asma");
		Pas_admin.setPrenom("ben hamad");
		Pas_admin.setTel(24169699);
		Pas_admin.setDateNaissance("02/09/1991");
		Pas_admin.setSexe("femme");
		Pas_admin.setEmail("Asma.242009@gmail.com");
		Pas_admin.setAdresse("Tunis");
		Pas_admin.setNumCNSS("Cd_123456");
		Pas_admin.setPassword("As.123456");
		Set<Role> roles = new HashSet<>();
		roles.add(admin);
		Pas_admin.setRoles(roles);


		this.patientRepository.save(Pas_admin);
		Patient Pas_user =new Patient();
		Pas_user.setNom("bacel");
		Pas_user.setPrenom("ben hamouda");
		Pas_user.setTel(21989699);
		Pas_user.setDateNaissance("15/09/1990");
		Pas_user.setSexe("Male");
		Pas_user.setEmail("Bac.209@gmail.com");
		Pas_user.setAdresse("Gabas");
		Pas_user.setNumCNSS("Cd_1456");
		Pas_user.setPassword("Bs.123456");
		Set<Role> roles2 = new HashSet<>();
		roles2.add(user);
		Pas_user.setRoles(roles2);
		this.patientRepository.save(Pas_user);

	}
}
