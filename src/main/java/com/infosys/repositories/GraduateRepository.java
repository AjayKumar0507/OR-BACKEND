package com.infosys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infosys.entities.Graduate;

@Repository
public interface GraduateRepository extends JpaRepository<Graduate, Integer>{

	@Query("SELECT g FROM Graduate g WHERE g.role.roleId = :roleId")
	Graduate getByRoleId(String roleId);

}
