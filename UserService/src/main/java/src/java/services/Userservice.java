package src.java.services;

import java.util.List;

import src.java.model.Role;
import src.java.model.User;

public interface Userservice {

	User saveUser(User user);

	Role saveRole(Role role);

	void addRoletoUser(String username, String rolename);

	User getUser(String username);

	List<User> getUsers();

	
	
	
}
