package io.dailydev.r3vl.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.dailydev.r3vl.api.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
}
