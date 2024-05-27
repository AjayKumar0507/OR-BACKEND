package com.infosys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.entities.Appointments;
import com.infosys.entities.Employer;

@Repository
public interface AppointmentsRepository extends JpaRepository<Appointments, Integer> {

}
