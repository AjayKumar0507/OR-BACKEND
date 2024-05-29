package com.infosys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.entities.Appointments;
import com.infosys.entities.Job;
import com.infosys.services.AppointmentsService;

@RestController
@CrossOrigin("http://localhost:4200")
public class AppointmentsController {

	@Autowired
	AppointmentsService appointmentsService;
	
	@PostMapping("/addAppointment")
	public void addAppointment(@RequestBody Appointments appointment) {
		appointmentsService.addAppointment(appointment);
	}
	
	@GetMapping("/getAllAppointments")
	public List<Appointments> getAllAppointments(){
		return appointmentsService.getAllAppointments();
	}
	
	@GetMapping("/getJobsAppliedByRoleId/{roleId}")
	public List<Job> getJobsAppliedByRoleId(@PathVariable String roleId){
		return appointmentsService.getJobsAppliedByRoleId(roleId);
	}

}
