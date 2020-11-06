package com.cts.pss.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.pss.dao.FlightDao;
import com.cts.pss.entity.Flight;

@Service
public class FlightServiceImpl implements FlightService {
	
	@Autowired
	private FlightDao flightDao;
	
	@Override
	public Flight save(Flight flight) {
		return flightDao.save(flight);
	}
	
	@Override
	public Flight findByFlightId(long id) {
		return flightDao.findById(id).orElse(null);
	}
	
	@Override
	public List<Flight> findByFlightDateAndOriginAndDestination(LocalDate flightDate,String origin,String destination,int numberofPassengers){
		List<Flight> flights=flightDao.findByFlightDateAndOriginAndDestination(flightDate, origin, destination);
		
		Stream<Flight> searchResults=flights.stream().filter(flight->flight.getInventory().getCount()>=numberofPassengers);
		return searchResults.collect(Collectors.toList());
	}
	
	@Override
	public Flight findByFlightNumberAndFlightDate(String flightNumber,LocalDate flightDate) {
		return flightDao.findByFlightNumberAndFlightDate(flightNumber, flightDate);
	}
	
	@Override
	public Flight updateFlightTime(long id,LocalTime newTime) {
		Flight flight=flightDao.findById(id).orElse(null);
		flight.setFlightTime(newTime);
		flightDao.save(flight);
		return flight;	
	}
	
	@Override
	public Flight updateFlightDate(long id,LocalDate newDate) {
		Flight flight=flightDao.findById(id).orElse(null);
		flight.setFlightDate(newDate);
		flightDao.save(flight);
		return flight;	
	}
	
	@Override
	public Flight updateFlightDateAndTime(long id,LocalDate flightDate,LocalTime flightTime) {
		Flight flight=flightDao.findById(id).orElse(null);
		flight.setFlightDate(flightDate);
		flight.setFlightTime(flightTime);
		return flightDao.save(flight);
	}
	@Override
	public void deleteFlight(long id) {
		flightDao.deleteById(id);
	}
	
	
	
	
	

}
