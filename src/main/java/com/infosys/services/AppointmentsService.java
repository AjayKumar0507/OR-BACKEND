package com.infosys.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.infosys.entities.Appointments;
import com.infosys.entities.Job;
import com.infosys.entities.Role;
import com.infosys.repositories.AppointmentsRepository;
import com.infosys.repositories.JobRepository;

@Service
public class AppointmentsService implements AppointmentsServiceInterface{

	@Autowired
	AppointmentsRepository appointmentsRepository;
	
	@Autowired
	JobRepository jobRepository;
	/*
	public Appointments addAppointment(int jobId, String fullName, String email, String phoneNo,
            String college, String collegeAddress, String yearOfPassing,
            String percentage, String skills, String project,
            MultipartFile file, Role role) throws IOException {

			byte[] fileBytes = file.getBytes(); // Convert MultipartFile to byte array
			Appointments appointment = Appointments.builder()
			.jobId(jobId)
			.fullName(fullName)
			.email(email)
			.phoneNo(phoneNo)
			.college(college)
			.collegeAddress(collegeAddress)
			.yearOfPassing(yearOfPassing)
			.percentage(percentage)
			.skills(skills)
			.project(project)
			.resume(fileBytes)
			.rolea(role)
			.build();
			
			
	
			return appointmentsRepository.save(appointment);
	}*/
	
	public Appointments addAppointment(Appointments appointment) {
		// , MultipartFile file
	    //  Appointments savedAppointment 
	    return appointmentsRepository.save(appointment);
	     // this.updateAppointment(savedAppointment);
	    // , file
	}

	public void updateAppointment(int jobId, MultipartFile file) {
	    Optional<Appointments> demo = appointmentsRepository.findById(jobId);
	    System.out.println("in service layer");
	    if (demo.isPresent()) {
	        try {
	            demo.get().setResume(file.getBytes());
	            System.out.println("inside try block");
	            appointmentsRepository.save(demo.get());
	        } catch (IOException e) {
	            // Handle the exception
	        }
	    } else {
	        // Handle the case where the appointment is not found
	    }
	}


	
	public List<Appointments> getAllAppointments(){
		return appointmentsRepository.findAll();
	}
	
	public List<Job> getJobsAppliedByRoleId(String roleId){
		List<Integer> jobIds =  appointmentsRepository.getAppointmentsByRoleId(roleId);
		
		return jobRepository.findJobsByIds(jobIds);
	}
}
