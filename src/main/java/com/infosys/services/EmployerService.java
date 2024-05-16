package com.infosys.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.infosys.entities.Employer;
import com.infosys.repositories.EmployerRepository;

@Service
public class EmployerService {
    
    private final EmployerRepository employerRepository;

    public EmployerService(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }


    public List<Employer> getAllEmployers() {
        return employerRepository.findAll();
    }

    public void addEmployer(Employer employer) {
        employerRepository.save(employer);
    }

    public Employer getEmployerById(String id) {
    	return employerRepository.getByRoleId(id);
    }
    
    public void deleteEmployer(Employer employer) {
        employerRepository.delete(employer);
    }
}
