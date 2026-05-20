package com.cmpe131.travel.controller;
import com.cmpe131.travel.dto.BookingRequest;
import com.cmpe131.travel.dto.BookingResponse;
import com.cmpe131.travel.service.BookingService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {

    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    // POST /api/v1/bookings
    @PostMapping({"", "/"})
    public BookingResponse createBooking(@RequestBody BookingRequest request) {
        return service.createBooking(request);
    }

    // GET /api/v1/bookings/{bookingId}
    @GetMapping("/{bookingId}")
    public BookingResponse getBooking(@PathVariable Long bookingId) {
        return service.getBookingById(bookingId);
    }

    // GET /api/v1/bookings/user/{userId}
    @GetMapping("/user/{userId}")
    public List<BookingResponse> getBookingsByUser(@PathVariable Long userId) {
        return service.getBookingsByUserId(userId);
    }

    @GetMapping("/by-agent-user")
    public List<BookingResponse> getBookingsByAgentAndUser(@RequestParam("agent_id") Long agentId, @RequestParam("user_id") Long userId) {
        return service.getBookingsByUserId(userId);
    }

}