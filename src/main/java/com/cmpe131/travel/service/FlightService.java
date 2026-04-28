package com.cmpe131.travel.service;
import com.cmpe131.travel.dto.FlightReservationRequest;
import com.cmpe131.travel.dto.FlightReservationResponse;
import com.cmpe131.travel.model.FlightReservation;
import com.cmpe131.travel.repository.FlightReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    private final FlightReservationRepository repository;


    public FlightService(FlightReservationRepository repository) {
        this.repository = repository;
    }

    public FlightReservationResponse createFlightReservation(FlightReservationRequest req) {
        FlightReservation r = new FlightReservation();
        r.setBookingId(req.getBookingId());
        r.setAirlineCode(req.getAirlineCode());
        r.setFlightNumber(req.getFlightNumber());
        r.setDepartureDate(req.getDepartureDate());
        r.setDepartureTime(req.getDepartureTime());
        r.setArriveDate(req.getArriveDate());
        r.setArriveTime(req.getArriveTime());
        r.setRate(req.getRate());
        r.setOriginAirportCode(req.getOriginAirportCode());
        r.setDestinationAirportCode(req.getDestinationAirportCode());

        FlightReservation savedReservation = repository.save(r); //save into database

        return response(savedReservation);
    }



    private FlightReservationResponse response(FlightReservation r) {
        return new FlightReservationResponse(r.getReservationNo(), r.getBookingId(), r.getAirlineCode(), r.getFlightNumber(), r.getDepartureDate(), r.getDepartureTime(), r.getArriveDate(), r.getArriveTime(), r.getRate(), r.getOriginAirportCode(), r.getDestinationAirportCode());
    }

}