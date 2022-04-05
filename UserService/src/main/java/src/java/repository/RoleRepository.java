package src.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import src.java.model.Role;


public interface RoleRepository extends JpaRepository<Role,Long>{
	Role findByName(String name);
}
