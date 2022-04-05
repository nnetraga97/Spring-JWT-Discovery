package src.java.api;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import src.java.model.Role;
import src.java.model.User;
import src.java.services.Userservice;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {
	
	private final Userservice userService;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers(){
		return ResponseEntity.ok().body(userService.getUsers());
	}
	
	@PostMapping("/user/save")
	public ResponseEntity<User> saveUser(@RequestBody User user){
			URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/v1/user/save").toUriString());
		return ResponseEntity.created(uri).body(userService.saveUser(user));
	}
	
	@PostMapping("/role/save")
	public ResponseEntity<Role> saveRole(@RequestBody Role role){
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/v1/role/save").toUriString());
		return ResponseEntity.created(uri).body(userService.saveRole(role));
	}
		
	
	@PostMapping("/role/addtouser")
	public ResponseEntity<?> addRoletoUser(@RequestBody RoleToUserForm form){

		userService.addRoletoUser(form.getUsername(),form.getRolename());
		return ResponseEntity.ok().build();
	}
	
	

	
}

@Data
class RoleToUserForm{
	private String username;
	private String rolename;
}

