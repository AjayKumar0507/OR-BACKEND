package com.infosys.services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.entities.Employer;
import com.infosys.entities.Role;
import com.infosys.entities.User;
import com.infosys.repositories.EmployerRepository;
import com.infosys.repositories.RoleRepository;
import com.infosys.repositories.UserRepository;

@Service
public class RoleService{
	
	@Autowired
	RoleRepository repository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	EmployerRepository employerRepository;
	
	public List<Role> getAllRoles() {
		/*String jpql = "SELECT r FROM Role r LEFT JOIN FETCH r.emp";
        TypedQuery<Role> query = entityManager.createQuery(jpql, Role.class);
        return query.getResultList();
		*/
		return repository.findAll();
	}

	public Role addRole(Role role) {
		
		return repository.save(role);
	}
	
	public void deleteRoleById(String roleId) {
	    Role role = repository.findById(roleId).orElse(null);
	    
	    if (role != null) {
	        User user = role.getUser();
	        
	        if (user != null) {
	            user.setRole(null); 
	            userRepository.delete(user);
	        }
	        
	        if(role.getRoleTitle()=="employer") {
	        	Employer employer = employerRepository.getByRoleId(role.getRoleId());
	        	employerRepository.delete(employer);
	        }
	        
	        repository.delete(role); // Delete the role
	    } else {
	        System.out.println("Role with id " + roleId + " not found.");
	    }
	}

	public Role getRoleInfoById(String roleId) {
		Optional<Role> optionalUser = repository.findById(roleId);
        return optionalUser.orElse(null);
	}

}
