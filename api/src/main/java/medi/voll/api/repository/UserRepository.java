package medi.voll.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import medi.voll.api.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findByEmail(String email);

    
}
