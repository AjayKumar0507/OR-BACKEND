package com.infosys.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.infosys.entities.Appointments;
import com.infosys.repositories.AppointmentsRepository;

@Service
public class AppointmentsService {

	@Autowired
	AppointmentsRepository appointmentsRepository;
	
	public void addAppointment(Appointments appointment) {
		appointmentsRepository.save(appointment);
	}
	
	public List<Appointments> getAllAppointments(){
		return appointmentsRepository.findAll();
	}
}
