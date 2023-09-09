package com.exam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.entity.Role;

public interface RoleRepo extends JpaRepository<Role,Long>{

	Role findByroleName(String name);

}
