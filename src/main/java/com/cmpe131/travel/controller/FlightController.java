package com.cmpe131.travel.controller;
import com.cmpe131.travel.dto.FlightReservationRequest;
import com.cmpe131.travel.dto.FlightReservationResponse;
import com.cmpe131.travel.service.BookingService;
import com.cmpe131.travel.service.FlightService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/flights")
public class FlightController {

    private final FlightService service;
    private final BookingService bookingService;

    public FlightController(FlightService service, BookingService bookingService) {
        this.service = service;
        this.bookingService = bookingService;
    }

    @PostMapping("/reservations")
    public FlightReservationResponse createFlightReservation(@RequestBody FlightReservationRequest request) {
        return service.createFlightReservation(request);
    }

    // Now pulls flight info from Bookings table instead of Flight_Reservations
    @GetMapping("/reservations/{bookingId}")
    public FlightReservationResponse getFlightReservationByBookingId(@PathVariable Long bookingId) {
        return bookingService.getFlightByBookingId(bookingId);
    }

    @GetMapping("/search")
    public String searchFlights(@RequestParam String fromCode, @RequestParam String toCode, @RequestParam String departDate, @RequestParam String returnDate, @RequestParam(defaultValue = "1") int adults) {
        return service.searchFlights(fromCode, toCode, departDate, returnDate, adults);
    }


}
