package com.infosys.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.infosys.entities.Graduate;
import com.infosys.repositories.GraduateRepository;

@Service
public class GraduateService  {
    
    private final GraduateRepository graduateRepository;

    public GraduateService(GraduateRepository graduateRepository) {
        this.graduateRepository = graduateRepository;
    }


    public List<Graduate> getAllGraduates() {
        return graduateRepository.findAll();
    }
    
    public Graduate getGraduateById(String id) {
    	return graduateRepository.getByRoleId(id);
    }
    public void addGraduate(Graduate graduate) {
        graduateRepository.save(graduate);
    }
    public void deleteGraduate(Graduate graduate) {
        graduateRepository.delete(graduate);
    }

	
}
