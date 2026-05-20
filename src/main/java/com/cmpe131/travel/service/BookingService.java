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
import com.cmpe131.travel.dto.HotelReservationResponse;

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

        Booking booking = new Booking();

        booking.setUserId(req.getUserId());
        booking.setAgentId(req.getAgentId());
        booking.setStartDate(req.getStartDate());
        booking.setEndDate(req.getEndDate());

        Booking savedBooking = repository.save(booking);

        if (req.getHotelReservations() != null) {
            for (BookingRequest.HotelReservationItem item : req.getHotelReservations()) {

                HotelReservation hr = new HotelReservation();

                hr.setBookingId(savedBooking.getBookingId());
                hr.setHotelCode(String.valueOf(item.getHotelCode()));
                hr.setCheckInDate(item.getCheckInDate());
                hr.setCheckOutDate(item.getCheckOutDate());
                hr.setHotelRate(item.getRate());

                hotelReservationRepository.save(hr);
            }
        }

        if (req.getFlightReservations() != null) {
            for (BookingRequest.FlightReservationItem item : req.getFlightReservations()) {

                FlightReservation fr = new FlightReservation();

                fr.setBookingId(savedBooking.getBookingId());
                fr.setAirlineCode(item.getAirlineCode());
                fr.setFlightNumber(item.getFlightNumber());
                fr.setDepartureDate(item.getDepartureDate());
                fr.setDepartureTime(item.getDepartureTime());
                fr.setArriveDate(item.getArriveDate());
                fr.setArriveTime(item.getArriveTime());
                fr.setRate(item.getRate());
                fr.setOriginAirportCode(item.getOriginAirportCode());
                fr.setDestinationAirportCode(item.getDestinationAirportCode());

                flightReservationRepository.save(fr);
            }
        }
        return getBookingById(savedBooking.getBookingId());
    }




    public BookingResponse getBookingById(Long bookingId) {
        Booking booking = repository.findById(bookingId).orElse(null);

        if (booking == null) {
            return null;
        }

        List<HotelReservationResponse> hotels =
                hotelReservationRepository.findByBookingId(bookingId)
                        .stream()
                        .map(h -> new HotelReservationResponse(
                                h.getReservationNo(),
                                h.getBookingId(),
                                h.getHotelCode(),
                                h.getHotelName(),
                                h.getCheckInDate(),
                                h.getCheckOutDate(),
                                h.getHotelRate()
                        ))
                        .toList();

        List<FlightReservationResponse> flights =
                flightReservationRepository.findByBookingId(bookingId)
                        .stream()
                        .map(f -> new FlightReservationResponse(
                                f.getReservationNo(),
                                f.getBookingId(),
                                f.getAirlineCode(),
                                f.getFlightNumber(),
                                f.getDepartureDate(),
                                f.getDepartureTime(),
                                f.getArriveDate(),
                                f.getArriveTime(),
                                f.getRate(),
                                f.getOriginAirportCode(),
                                f.getDestinationAirportCode()
                        ))
                        .toList();

        return new BookingResponse(
                booking.getBookingId(),
                booking.getUserId(),
                booking.getAgentId(),
                booking.getStartDate(),
                booking.getEndDate(),
                hotels,
                flights
        );
    }





    public List<BookingResponse> getBookingsByUserId(Long userId) {
        return repository.findByUserId(userId)
            .stream()
            .map(b -> getBookingById(b.getBookingId()))
            .toList();
    }




}