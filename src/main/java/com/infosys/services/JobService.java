package com.infosys.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.entities.Job;
import com.infosys.repositories.JobRepository;

@Service
public class JobService{

	@Autowired
	private JobRepository repository;

	public List<Job> getAllJobs(){
		return  repository.findAll();
	}
	
	public Job addJob(Job job) {
		return repository.save(job);
	}
	/*
	
	public List<Job> getJobsByEmpId(String id){
		return repository.getJobsByEmpId(id);
	}
	*/

	public Job updateJob(int id , Job job) {
		Optional<Job> optionalExistingUser = repository.findById(id);
        if (optionalExistingUser.isPresent()) {
        	
            Job existingUser = optionalExistingUser.get();
            existingUser.setJobId(job.getJobId());
            existingUser.setJobName(job.getJobName());
            existingUser.setJobSalary(job.getJobSalary());
            existingUser.setJobType(job.getJobType());
            existingUser.setJobDescription(job.getJobDescription());
            existingUser.setJobVacancy(job.getJobVacancy());
            
            return repository.save(existingUser);
        } else {
            return null;
        }
	}

	public void deleteJobById(int id) {
		repository.deleteById(id); ;
	}

	public Job searchJobById(int id) {
		Optional<Job> optionalJob = repository.findById(id);
        return optionalJob.orElse(null);
	}

}
