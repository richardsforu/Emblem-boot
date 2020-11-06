package com.cts.pss.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.pss.entity.Flight;

public interface FlightDao  extends JpaRepository<Flight, Long>{
	
	List<Flight> findByFlightDateAndOriginAndDestination(LocalDate flightDate,String origin,String destination);
	Flight findByFlightNumberAndFlightDate(String flightNumber,LocalDate flightDate);

}
