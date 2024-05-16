package com.infosys.services;

import java.util.List;

import com.infosys.entities.User;

public interface UserServiceInterface {

	User updateUser(int id, User user);

	List<User> getAllUsers();

	User addUser(User user);

	void deleteUserById(int id);

	User getUserInfoByUserEmail(String email);

}
