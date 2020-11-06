package com.cts.pss.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.cts.pss.entity.Flight;

public interface FlightService {

	Flight save(Flight flight);

	Flight findByFlightId(long id);

	List<Flight> findByFlightDateAndOriginAndDestination(LocalDate flightDate, String origin, String destination,int numberofPassengers);

	Flight findByFlightNumberAndFlightDate(String flightNumber, LocalDate flightDate);

	Flight updateFlightTime(long id, LocalTime newTime);

	Flight updateFlightDate(long id, LocalDate newDate);

	Flight updateFlightDateAndTime(long id, LocalDate flightDate, LocalTime flightTime);

	void deleteFlight(long id);

}