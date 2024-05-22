package com.infosys.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.infosys.entities.Job;

public interface JobRepository extends JpaRepository<Job, Integer> {
    
    @Query("SELECT j FROM Job j WHERE j.roles.roleId = :roleId")
    List<Job> getJobsByRoleId(String roleId);
}
