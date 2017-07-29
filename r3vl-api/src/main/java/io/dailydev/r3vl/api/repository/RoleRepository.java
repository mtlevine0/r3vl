package io.dailydev.r3vl.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.dailydev.r3vl.api.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
