package com.cg.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.quiz.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
