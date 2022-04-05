/**
 * 
 */
package src.java.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import src.java.model.Role;
import src.java.model.User;
import src.java.repository.RoleRepository;
import src.java.repository.UserRepository;

/**
 * @author Nikhil
 *
 */

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional

public class UserServiceImplementation implements Userservice,UserDetailsService {
	
	
	private final UserRepository userRepo ;
	private final RoleRepository roleRepo ;
	private final PasswordEncoder passwordEncoder;
	
	
	@Override
	public User saveUser(User user) {
		log.info("Saving new user to db");
		user.setPassword(passwordEncoder.encode(user.getPassword()	));
		return userRepo.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		log.info("Saving new role to db");
		return roleRepo.save(role);
	}

	@Override
	public void addRoletoUser(String username, String rolename) {
		User user = userRepo.findByUsername(username);
		Role role = roleRepo.findByName(rolename);
		log.info("Saving new role to user ");
		user.getRoles().add(role);
		
	}

	@Override
	public User getUser(String username) {
		log.info("finding user:"+username);
		return userRepo.findByUsername(username);
	}

	@Override
	public List<User> getUsers() {
		log.info("get all users");
		return userRepo.findAll();
	}

	/*telling spring to look here for users by extending*/
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("Looking for user:"+username);
		User user = userRepo.findByUsername(username);
		if(user==null) {
			log.error(username);
			throw new UsernameNotFoundException("User not in db");
		}
		else {
			log.info("User found in DB");
			
		}
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		user.getRoles().forEach(role ->{
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		});
		return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
	}

}
