package com.cmpe131.travel.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cmpe131.travel.dto.HotelDTO;
import com.cmpe131.travel.dto.HotelReservationResponse;
import com.cmpe131.travel.model.HotelReservation;
import com.cmpe131.travel.repository.HotelReservationRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class HotelService {

    private final PetFilterService petFilterService;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final HotelReservationRepository hotelReservationRepository;

    @Value("${rapidapi.key}")
    private String apiKey;

    @Value("${rapidapi.host}")
    private String apiHost;

    public HotelService(PetFilterService petFilterService, HotelReservationRepository hotelReservationRepository) {
        this.petFilterService = petFilterService;
        this.hotelReservationRepository = hotelReservationRepository;
    }

    public String getRawResponse(String destId, String checkin, String checkout) {
        try {
            String url = "https://booking-com.p.rapidapi.com/v1/hotels/search"
                + "?dest_id=" + destId
                + "&checkin_date=" + checkin
                + "&checkout_date=" + checkout
                + "&adults_number=2"
                + "&room_number=1"
                + "&dest_type=city"
                + "&filter_by_currency=USD"
                + "&currency=USD"
                + "&locale=en-gb"
                + "&order_by=popularity"
                + "&units=metric";

            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("x-rapidapi-key", apiKey)
                .header("x-rapidapi-host", apiHost)
                .GET()
                .build();

            return HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString())
                .body();

        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public List<HotelDTO> searchHotels(String destId, String checkin, String checkout, int adults, int roomNumber) {
        try {
            String url = "https://booking-com.p.rapidapi.com/v1/hotels/search"
                + "?dest_id=" + destId
                + "&checkin_date=" + checkin
                + "&checkout_date=" + checkout
                + "&adults_number=" + adults
                + "&room_number=" + roomNumber
                + "&dest_type=city"
                + "&filter_by_currency=USD"
                + "&currency=USD"
                + "&locale=en-gb"
                + "&order_by=popularity"
                + "&units=metric";

            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("x-rapidapi-key", apiKey)
                .header("x-rapidapi-host", apiHost)
                .GET()
                .build();

            HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

            return parseHotels(response.body());

        } catch (Exception e) {
            return List.of();
        }
    }

    public List<HotelDTO> searchPetFriendlyHotels(String destId, String checkin, String checkout, int adults, int roomNumber) {
        return searchHotels(destId, checkin, checkout, adults, roomNumber)
            .stream()
            .filter(h -> petFilterService.isPetFriendly(h.getDescription()))
            .toList();
    }

    private List<HotelDTO> parseHotels(String json) throws Exception {
    List<HotelDTO> hotels = new ArrayList<>();
    JsonNode root = objectMapper.readTree(json);
    JsonNode results = root.path("result");

    for (JsonNode hotel : results) {
        String hotelName    = hotel.path("hotel_name").asText();
        String description  = hotel.path("unit_configuration_label").asText();
        String address      = hotel.path("address_trans").asText(); // ← was "address"
        double price        = hotel.path("composite_price_breakdown")
                                   .path("gross_amount_hotel_currency")
                                   .path("value").asDouble();       // ← was "min_total_price"
        boolean petFriendly = petFilterService.isPetFriendly(description);

        hotels.add(new HotelDTO(hotelName, description, address, price, petFriendly));
    }

    return hotels;
    }

    private HotelReservationResponse toResponse(HotelReservation r) {
    return new HotelReservationResponse(
            r.getReservationNo(),
            r.getBookingId(),
            r.getHotelCode(),
            r.getHotelName(),
            r.getCheckInDate(),
            r.getCheckOutDate(),
            r.getHotelRate()
        );
    }

    public HotelReservationResponse getHotelReservationByBookingId(Long bookingId) {
        Optional<HotelReservation> reservation = hotelReservationRepository
                .findByBookingId(bookingId)
                .stream()
                .findFirst();
        return reservation.map(this::toResponse).orElse(null);
    }
}