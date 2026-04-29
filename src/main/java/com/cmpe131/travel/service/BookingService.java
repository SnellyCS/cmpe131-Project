package com.cmpe131.travel.service;
import com.cmpe131.travel.dto.BookingRequest;
import com.cmpe131.travel.dto.BookingResponse;
import com.cmpe131.travel.dto.FlightReservationResponse;
import com.cmpe131.travel.model.Booking;
import com.cmpe131.travel.repository.BookingRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository repository;

    public BookingService(BookingRepository repository) {
        this.repository = repository;
    }

    public BookingResponse createBooking(BookingRequest req) {
        Booking b = new Booking();
        b.setUserId(req.getUserId());
        b.setUserName(req.getUserName());
        b.setUserEmail(req.getUserEmail());
        b.setAirlineCode(req.getAirlineCode());
        b.setFlightNumber(req.getFlightNumber());
        b.setOriginAirportCode(req.getOriginAirportCode());
        b.setDestinationAirportCode(req.getDestinationAirportCode());
        b.setDepartureDate(req.getDepartureDate());
        b.setDepartureTime(req.getDepartureTime());
        b.setArriveDate(req.getArriveDate());
        b.setArriveTime(req.getArriveTime());
        b.setFlightRate(req.getFlightRate());
        b.setHotelCode(req.getHotelCode());
        b.setHotelName(req.getHotelName());
        b.setCheckInDate(req.getCheckInDate());
        b.setCheckOutDate(req.getCheckOutDate());
        b.setHotelRate(req.getHotelRate());

        Booking saved = repository.save(b);
        return toResponse(saved);
    }

    public BookingResponse getBookingById(Long bookingId) {
        Optional<Booking> booking = repository.findById(bookingId);
        return booking.map(this::toResponse).orElse(null);
    }

    public List<BookingResponse> getBookingsByUserId(Long userId) {
        return repository.findByUserId(userId).stream()
                .map(this::toResponse)
                .toList();
    }

    private BookingResponse toResponse(Booking b) {
        return new BookingResponse(
                b.getBookingId(),
                b.getUserId(),
                b.getUserName(),
                b.getUserEmail(),
                b.getAirlineCode(),
                b.getFlightNumber(),
                b.getOriginAirportCode(),
                b.getDestinationAirportCode(),
                b.getDepartureDate(),
                b.getDepartureTime(),
                b.getArriveDate(),
                b.getArriveTime(),
                b.getFlightRate(),
                b.getHotelCode(),
                b.getHotelName(),
                b.getCheckInDate(),
                b.getCheckOutDate(),
                b.getHotelRate()
        );
    }

    public FlightReservationResponse getFlightByBookingId(Long bookingId) {
        Optional<Booking> booking = repository.findById(bookingId);
        if (booking.isEmpty()) return null;
        Booking b = booking.get();
        return new FlightReservationResponse(
            null,
            b.getBookingId(),
            b.getAirlineCode(),
            b.getFlightNumber(),
            b.getDepartureDate(),
            b.getDepartureTime(),
            b.getArriveDate(),
            b.getArriveTime(),
            b.getFlightRate(),
            b.getOriginAirportCode(),
            b.getDestinationAirportCode()
        );
    }
}