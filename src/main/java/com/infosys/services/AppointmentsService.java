package com.infosys.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.infosys.entities.Appointments;
import com.infosys.entities.Job;
import com.infosys.repositories.AppointmentsRepository;
import com.infosys.repositories.JobRepository;

@Service
public class AppointmentsService {

	@Autowired
	AppointmentsRepository appointmentsRepository;
	
	@Autowired
	JobRepository jobRepository;
	
	public void addAppointment(Appointments appointment) {
		appointmentsRepository.save(appointment);
	}
	
	public List<Appointments> getAllAppointments(){
		return appointmentsRepository.findAll();
	}
	
	public List<Job> getJobsAppliedByRoleId(String roleId){
		List<Integer> jobIds =  appointmentsRepository.getAppointmentsByRoleId(roleId);
		
		return jobRepository.findJobsByIds(jobIds);
	}
}
