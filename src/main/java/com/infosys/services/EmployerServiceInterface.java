package com.infosys.services;

import java.util.List;

import com.infosys.entities.Employer;

public interface EmployerServiceInterface {

	public List<Employer> getAllEmployers();

	void addEmployer(Employer employer);

	void deleteEmployer(Employer employer);

}
