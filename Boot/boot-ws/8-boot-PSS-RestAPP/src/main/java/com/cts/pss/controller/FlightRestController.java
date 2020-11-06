package com.cts.pss.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.pss.entity.Flight;
import com.cts.pss.service.FlightService;

@RestController
@RequestMapping("/api/pss")
public class FlightRestController {
	
	@Autowired
	private FlightService flightService;
	
	@GetMapping("/{flightDate}/{origin}/{destination}/{numberofPassengers}")
	public List<Flight> findFlightByDateAndOriginAndDestination(@PathVariable @DateTimeFormat(iso=ISO.DATE) LocalDate  flightDate,@PathVariable String origin,@PathVariable String destination,@PathVariable int numberofPassengers ){
		return flightService.findByFlightDateAndOriginAndDestination(flightDate, origin, destination,numberofPassengers) ;
	}
	
	@GetMapping("/{flightNumber}/{flightDate}")
	public Flight findByFlightNumberAndDate(@PathVariable String flightNumber,@PathVariable @DateTimeFormat(iso=ISO.DATE) LocalDate  flightDate) {
		return flightService.findByFlightNumberAndFlightDate(flightNumber, flightDate);
	}
	
	@PostMapping
	public Flight scheduleFlight(@RequestBody Flight flight) {
		return flightService.save(flight);
	}
	
	
	@GetMapping("/{id}")
	public Flight findByFlightId(@PathVariable long id) {
		return flightService.findByFlightId(id);
	}
	
	@PatchMapping("/{id}/{time}")
	public Flight updateFlightTime(@PathVariable long id,@PathVariable @DateTimeFormat(iso=ISO.TIME) LocalTime  time) {
		return flightService.updateFlightTime(id, time);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteFlight(@PathVariable long id) {
		flightService.deleteFlight(id);
	}
	
	
	
	
	

}
