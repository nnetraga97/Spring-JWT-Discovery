package src.java;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import src.java.services.Userservice;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {																																																																																																																																																													
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	CommandLineRunner run(Userservice userservice) {
		return args->{
			/*userservice.saveRole(new Role(null,"ROLE_USER"));
			userservice.saveRole(new Role(null,"ROLE_MANAGER"));
			userservice.saveRole(new Role(null,"ROLE_ADMIN"));
			userservice.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));
			
			userservice.saveUser(new User(null,"name","Nikhil","pwd",new ArrayList<>()));
			userservice.saveUser(new User(null,"john","John","pwd",new ArrayList<>()));
			userservice.saveUser(new User(null,"mike","Mike","pwd",new ArrayList<>()));
			userservice.saveUser(new User(null,"solar","Solar","pwd",new ArrayList<>()));
			userservice.saveUser(new User(null,"winnie","Winnie","pwd",new ArrayList<>()));
			
			userservice.addRoletoUser("John", "ROLE_USER");
			userservice.addRoletoUser("John", "ROLE_MANAGER");
			userservice.addRoletoUser("Nikhil", "ROLE_SUPER_ADMIN");
			userservice.addRoletoUser("Solar", "ROLE_MANAGER");
			userservice.addRoletoUser("Winnie", "ROLE_ADMIN");*/
			
		};
	}
}
