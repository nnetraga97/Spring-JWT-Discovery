package src.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import src.java.model.User;

public interface UserRepository extends JpaRepository<User,Long>{
	User findByUsername(String username);
}
