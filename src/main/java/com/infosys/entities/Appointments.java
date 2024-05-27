package com.infosys.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Appointments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String fullName;
	private String email;
	private String phoneNo;
	private String college;
	private String collegeAddress;
	private String yearOfPassing;
	private String percentage;
	private String skills;
	private String project;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roleId")
    private Role rolea;

	public Appointments(int id, String fullName, String email, String phoneNo, String college, String collegeAddress,
			String yearOfPassing, String percentage, String skills, String project, Role rolea) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.phoneNo = phoneNo;
		this.college = college;
		this.collegeAddress = collegeAddress;
		this.yearOfPassing = yearOfPassing;
		this.percentage = percentage;
		this.skills = skills;
		this.project = project;
		this.rolea = rolea;
	}

	public Appointments() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getCollegeAddress() {
		return collegeAddress;
	}

	public void setCollegeAddress(String collegeAddress) {
		this.collegeAddress = collegeAddress;
	}

	public String getYearOfPassing() {
		return yearOfPassing;
	}

	public void setYearOfPassing(String yearOfPassing) {
		this.yearOfPassing = yearOfPassing;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public Role getRolea() {
		return rolea;
	}

	public void setRolea(Role rolea) {
		this.rolea = rolea;
	}

	@Override
	public String toString() {
		return "Appointments [id=" + id + ", fullName=" + fullName + ", email=" + email + ", phoneNo=" + phoneNo
				+ ", college=" + college + ", collegeAddress=" + collegeAddress + ", yearOfPassing=" + yearOfPassing
				+ ", percentage=" + percentage + ", skills=" + skills + ", project=" + project + ", rolea=" + rolea
				+ "]";
	}
	
	
}