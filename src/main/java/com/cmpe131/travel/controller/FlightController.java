package com.cmpe131.travel.controller;
import com.cmpe131.travel.dto.FlightReservationRequest;
import com.cmpe131.travel.dto.FlightReservationResponse;
import com.cmpe131.travel.service.FlightService;
import org.springframework.web.bind.annotation.*;
<<<<<<< HEAD
import java.util.*;
=======
import java.util.List;
>>>>>>> 60bf45510c838b6f6787c7ef3d08af85a770eb67

@RestController
@RequestMapping("/api/v1/flights")
public class FlightController {

<<<<<<< HEAD
    @GetMapping("/search")
    public List<Map<String, Object>> searchFlights(
            @RequestParam String origin,
            @RequestParam String destination,
            @RequestParam String departDate
    ) {
        List<Map<String, Object>> flights = new ArrayList<>();

        Map<String, Object> flight1 = new HashMap<>();
        flight1.put("airline", "United");
        flight1.put("flightNumber", "UA123");
        flight1.put("origin", origin);
        flight1.put("destination", destination);
        flight1.put("departDate", departDate);
        flight1.put("price", 250);

        flights.add(flight1);

        return flights;
    }
}
=======
    private final FlightService service;

    public FlightController(FlightService service) {
        this.service = service;
    }


    @PostMapping("/reservations")
    public FlightReservationResponse createFlightReservation(@RequestBody FlightReservationRequest request) {
        return service.createFlightReservation(request);
    }

    @GetMapping("/reservations/{bookingId}")
    public List<FlightReservationResponse> getFlightReservationsByBookingId(@PathVariable Long bookingId) {
        return service.getFlightReservationsByBookingId(bookingId);
    }


    @GetMapping("/search")
    public String searchFlights(@RequestParam String fromCode, @RequestParam String toCode, @RequestParam String departDate, @RequestParam String returnDate, @RequestParam(defaultValue = "1") int adults) {
        return service.searchFlights(fromCode, toCode, departDate, returnDate, adults);
    }


}
>>>>>>> 60bf45510c838b6f6787c7ef3d08af85a770eb67
