package com.infosys.services;

import java.util.List;

import com.infosys.entities.Role;

public interface RoleServiceInterface {

	List<Role> getAllRoles();

	Role addRole(Role role);

	Role getRoleInfoById(int id);


	void deleteRoleById(int id);

}
