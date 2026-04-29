package com.cmpe131.travel.service;
import com.cmpe131.travel.dto.FlightReservationRequest;
import com.cmpe131.travel.dto.FlightReservationResponse;
import com.cmpe131.travel.model.FlightReservation;
import com.cmpe131.travel.repository.FlightReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class FlightService {

    private final FlightReservationRepository repository;

    @Value("${rapidapi.key}")
    private String apiKey;

    @Value("${rapidapi.host}")
    private String apiHost;


    public FlightService(FlightReservationRepository repository) {
        this.repository = repository;
    }

    public FlightReservationResponse createFlightReservation(FlightReservationRequest req) {
        FlightReservation r = new FlightReservation();
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


    public String searchFlights(String fromCode, String toCode, String departDate, String returnDate, int adults) {
        try {
            String url = "https://booking-com.p.rapidapi.com/v1/flights/search" + "?from_code=" + fromCode + "&to_code=" + toCode + "&depart_date=" + departDate + "&return_date=" + returnDate + "&adults=" + adults + "&currency=USD" + "&locale=en-gb" + "&order_by=BEST" + "&flight_type=ROUNDTRIP" + "&cabin_class=ECONOMY";
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).header("x-rapidapi-key", apiKey).header("x-rapidapi-host", apiHost).GET().build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }

    }


    public List<FlightReservationResponse> getFlightReservationsByBookingId(Long bookingId) {
        return repository.findByBookingId(bookingId).stream().map(this::response).toList();
    }



}