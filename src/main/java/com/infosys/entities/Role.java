package com.infosys.entities;

import java.util.ArrayList;
import java.util.List;

import com.carrotsearch.hppc.Generated;
import com.fasterxml.jackson.annotation.JsonIgnore;
// import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Role {
	
	@Id
	private String roleId;
	private String roleTitle;
	private String roleDesc;
	
	@OneToOne(mappedBy="role")
	@JsonIgnore
	private User user;
	
	@OneToMany(mappedBy = "roles", cascade = CascadeType.ALL)
    private List<Job> jobs = new ArrayList<>();
	
	
	public Role() {
		super();
	}


	public String getRoleId() {
		return roleId;
	}


	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}


	public Role(String roleId, String roleTitle, String roleDesc, User user) {
		super();
		this.roleId = roleId;
		this.roleTitle = roleTitle;
		this.roleDesc = roleDesc;
		this.user = user;
	}


	public String getRoleTitle() {
		return roleTitle;
	}

	public void setRoleTitle(String roleTitle) {
		this.roleTitle = roleTitle;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleTitle=" + roleTitle + ", roleDesc=" + roleDesc + ", user=" + user
				+ "]";
	}

	
}
