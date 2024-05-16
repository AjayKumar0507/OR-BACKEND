package com.infosys.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.entities.User;
import com.infosys.entities.Role;
import com.infosys.repositories.UserRepository;
import com.infosys.repositories.RoleRepository;

@Service
public class UserService implements UserServiceInterface {
    
	
    private final UserRepository userRepository;
    
    @Autowired
    RoleRepository roleRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
	public User getUserInfoByUserEmail(String email) {
		Optional<User> optionalUser =  Optional.of(userRepository.getUserInfoByUserEmail(email));
		return optionalUser.orElse(null);
	}
	
    public User getUserInfoByRoleId(String roleId) {
    	return userRepository.getUserByRoleId(roleId);
    }
	
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
    	int count = 0;
    	Role role = new Role();
    	if(user.getTypeOfUser().equals("graduate") ) {
    		count = roleRepository.countByRoleIdPrefix("grd");
    		count++;
    		role.setRoleTitle("graduate");
    		role.setRoleDesc("grd");
    		role.setRoleId("grd"+String.format("%05d",count ));
    		user.setRole(role);
    		
    	}
    	else {
    		count = roleRepository.countByRoleIdPrefix("emp");
    		count++;
    		role.setRoleTitle("employer");
    		role.setRoleDesc("emp");
    		role.setRoleId("emp"+String.format("%05d",count ));
    		user.setRole(role);
    	}
    	user.setRole(role);
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(int id, User user) {
        Optional<User> optionalExistingUser = userRepository.findById(id);
        if (optionalExistingUser.isPresent()) {
            User existingUser = optionalExistingUser.get();
            existingUser.setUserName(user.getUserName());
            existingUser.setUserEmail(user.getUserEmail());
            existingUser.setPassword(user.getPassword());
            existingUser.setNationality(user.getNationality());
            existingUser.setPhoneNo(user.getPhoneNo());
            
            return userRepository.save(existingUser);
        } else {
            return null;
        }
    }

	
}
