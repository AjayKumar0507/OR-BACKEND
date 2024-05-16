package com.infosys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.entities.Job;

public interface JobRepository extends JpaRepository<Job, Integer>{
	
	/*
	@Query("SELECT g FROM JOB g WHERE g.employerId = :empId")
	List getJobsByEmpId(String empId);
	*/
}
