package com.infosys.services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.entities.Role;
import com.infosys.entities.User;
import com.infosys.repositories.RoleRepository;
import com.infosys.repositories.UserRepository;

@Service
public class RoleService{
	
	@Autowired
	RoleRepository repository;
	
	@Autowired
	UserRepository userRepository;
	
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
	
	public void deleteRoleById(String id) {
		User user = repository.findById(id).get().getUser();
		System.out.println(user.toString());
		user.setRole(null);
		userRepository.save(user);
		repository.deleteById(id);
	}

	public Role getRoleInfoById(String roleId) {
		Optional<Role> optionalUser = repository.findById(roleId);
        return optionalUser.orElse(null);
	}

}
