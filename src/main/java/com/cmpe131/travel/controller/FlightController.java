package com.cmpe131.travel.controller;
import com.cmpe131.travel.dto.FlightReservationRequest;
import com.cmpe131.travel.dto.FlightReservationResponse;
import com.cmpe131.travel.service.FlightService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/flights")
public class FlightController {

    private final FlightService service;

    public FlightController(FlightService service) {
        this.service = service;
    }

    @PostMapping("/reservations")
    public FlightReservationResponse createFlightReservation(@RequestBody FlightReservationRequest request) {
        return service.createFlightReservation(request);
    }

    // Now pulls flight info from Bookings table instead of Flight_Reservations
    /*
    @GetMapping("/reservations/{bookingId}")
    public FlightReservationResponse getFlightReservationByBookingId(@PathVariable Long bookingId) {
        return bookingService.getFlightByBookingId(bookingId);
    }
    */

    @GetMapping("/reservations/reservation/{reservationNo}")
    public FlightReservationResponse getFlightReservationByReservationNo(@PathVariable Long reservationNo) {
        return service.getFlightReservationByReservationNo(reservationNo);
    }

    @GetMapping("/search")
    public String searchFlights(
            @RequestParam("from_code") String fromCode,
            @RequestParam("to_code") String toCode,
            @RequestParam("depart_date") String departDate,
            @RequestParam(value = "return_date", required = false) String returnDate,
            @RequestParam(defaultValue = "1") int adults,
            @RequestParam(defaultValue = "0") int children
    ) {
        //fromCode = fromCode.replace(".AIRPORT", "");
        //toCode = toCode.replace(".AIRPORT", "");

        return service.searchFlights(fromCode, toCode, departDate, returnDate, adults);
    }


}
