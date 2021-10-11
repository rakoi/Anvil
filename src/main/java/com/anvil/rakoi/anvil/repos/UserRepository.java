package com.anvil.rakoi.anvil.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.anvil.rakoi.anvil.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Repository
public interface UserRepository extends PagingAndSortingRepository<User,Integer> {

	Optional<User> getUserByUsername(String username);
}
