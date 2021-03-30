package com.anvil.rakoi.anvil.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anvil.rakoi.anvil.entities.User;

public interface UserRepository extends JpaRepository<User,Integer> {

	Optional<User> getUserByUsername(String username);
}
