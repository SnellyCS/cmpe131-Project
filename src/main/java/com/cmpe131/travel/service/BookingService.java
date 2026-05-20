package com.cmpe131.travel.service;
import com.cmpe131.travel.dto.BookingRequest;
import com.cmpe131.travel.dto.BookingResponse;
import com.cmpe131.travel.dto.FlightReservationResponse;
import com.cmpe131.travel.dto.HotelDTO;
import com.cmpe131.travel.model.Booking;
import com.cmpe131.travel.repository.BookingRepository;
import com.cmpe131.travel.model.HotelReservation;
import com.cmpe131.travel.repository.HotelReservationRepository;
import com.cmpe131.travel.model.FlightReservation;
import com.cmpe131.travel.repository.FlightReservationRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository repository;
    private final HotelReservationRepository hotelReservationRepository;
    private final FlightReservationRepository flightReservationRepository;

    public BookingService(BookingRepository repository, HotelReservationRepository hotelReservationRepository, FlightReservationRepository flightReservationRepository) {
        this.repository = repository;
        this.hotelReservationRepository = hotelReservationRepository;
        this.flightReservationRepository = flightReservationRepository;
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

        HotelReservation hr = new HotelReservation();
        hr.setBookingId(saved.getBookingId());
        hr.setHotelCode(req.getHotelCode());
        hr.setHotelName(req.getHotelName());
        hr.setCheckInDate(req.getCheckInDate());
        hr.setCheckOutDate(req.getCheckOutDate());
        hr.setHotelRate(req.getHotelRate());

        hotelReservationRepository.save(hr);

        FlightReservation fr = new FlightReservation();
        fr.setBookingId(saved.getBookingId());
        fr.setAirlineCode(req.getAirlineCode());
        fr.setFlightNumber(req.getFlightNumber());
        fr.setDepartureDate(req.getDepartureDate());
        fr.setDepartureTime(req.getDepartureTime());
        fr.setArriveDate(req.getArriveDate());
        fr.setArriveTime(req.getArriveTime());
        fr.setRate(req.getFlightRate());
        fr.setOriginAirportCode(req.getOriginAirportCode());
        fr.setDestinationAirportCode(req.getDestinationAirportCode());
        
        flightReservationRepository.save(fr);

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

    public HotelDTO getHotelByBookingId(Long bookingId) {
        Optional<Booking> booking = repository.findById(bookingId);
        if (booking.isEmpty()) return null;
        Booking b = booking.get();
        return new HotelDTO(
            b.getHotelName(),
            null,        // description - not stored on Booking
            null,        // address - not stored on Booking
            b.getHotelRate().doubleValue(),
            false        // isPetFriendly - not stored on Booking
        );
    }
}