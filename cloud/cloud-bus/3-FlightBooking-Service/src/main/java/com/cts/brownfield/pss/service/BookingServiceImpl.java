package com.cts.brownfield.pss.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.brownfield.pss.controller.Sender;
import com.cts.brownfield.pss.dao.BookingRecordDao;
import com.cts.brownfield.pss.dao.PassengerDao;
import com.cts.brownfield.pss.entity.BookingRecord;
import com.cts.brownfield.pss.entity.Fares;
import com.cts.brownfield.pss.entity.Flight;
import com.cts.brownfield.pss.entity.Passenger;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private PassengerDao passengerDao;
	@Autowired
	private BookingRecordDao bookingRecord;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private Sender sender;

	private static final String FARESURL = "http://localhost:8081/api/pss";
	private static final String FINDFLIGHT = "http://localhost:8082/api/pss";

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Override
	public Passenger bookFlight(Passenger passenger, long id, int numberOfPassengers) {

		Fares fare = null;
		Flight flight = null;
		BookingRecord bookingRecord = null;

		try {

			fare = restTemplate.getForObject(FARESURL + "/getFare/" + id, Fares.class);
			flight = restTemplate.getForObject(FINDFLIGHT + "/findFlight/" + id, Flight.class);

			System.out.println("=====> Fare: " + fare);
			System.out.println("Flight: " + flight);
		} catch (Exception e) {
			System.out.println("Fares Service is Not Available");
		}

		if (flight.getInventory().getCount() < numberOfPassengers) {
			System.out.println("No More Seats Available");
		}
		if (flight != null) {
			bookingRecord = new BookingRecord(flight.getFlightNumber(), flight.getOrigin(), flight.getDestination(),
					flight.getFlightDate(), flight.getFlightTime(), LocalDateTime.now(), fare.getFare(), "Confirmed");
			// bookingRecord.setPassenger(passenger);
			bookingRecord.setFare(fare.getFare() * numberOfPassengers);
			passenger.setBookingRecord(bookingRecord);
			if (passenger.getCoPassengers().size() == numberOfPassengers - 1) {

				passengerDao.save(passenger);
				
				// Send Email to Email-Service appp....
				
				Map<String, Object> passengerDetails = new HashMap<String, Object>();
				passengerDetails.put("NAME", passenger.getFirstName());
				passengerDetails.put("FLIGHT_NUMBER", passenger.getBookingRecord().getFlightNumber());
				passengerDetails.put("ORIGIN", passenger.getBookingRecord().getOrigin());
				passengerDetails.put("DESTINATION", passenger.getBookingRecord().getDestination());
				passengerDetails.put("DATE", passenger.getBookingRecord().getFlightDate());
				passengerDetails.put("TIME", passenger.getBookingRecord().getFlightTime());
				
				
				sender.sendEmail(passengerDetails);

				
			}
		}

		// Send New Inventory details to Search microservice via RabbitMQ to update new
		// inventory in search schema
		Map<String, Object> bookingDetails = new HashMap<String, Object>();
		bookingDetails.put("FLIGHT_NUMBER", flight.getFlightNumber());
		bookingDetails.put("FLIGHT_DATE", flight.getFlightDate());
		bookingDetails.put("NEW_INVENTORY", numberOfPassengers);

		sender.send(bookingDetails);

		return passenger;
	}

	// The below method is invoked after checked-in to change status from
	// BOOKING_CONFIRMED TO CHECKED_IN
	public void updateStatus(String status, long bookingId) {
		BookingRecord record = bookingRecord.findById(bookingId).orElse(null);
		if (record != null) {
			System.out.println(">>>>> Updating status = " + status + " of bookingId = " + bookingId + " <<<<");
			record.setStatus(status);
			bookingRecord.save(record);
		}
	}

	public BookingRecord getBookingInfo(long bookingId) {

		return bookingRecord.findById(bookingId).orElse(null);
	}

}
