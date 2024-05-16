package com.infosys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infosys.entities.Employer;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Integer> {
	@Query("SELECT g FROM Employer g WHERE g.role.roleId = :roleId")
	Employer getByRoleId(String roleId);
}
