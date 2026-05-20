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

    public List<HotelDTO> searchHotels(String cityName, String checkin, String checkout, int adults, int roomNumber) {
        try {
            String destId = getDestinationId(cityName);
            System.out.println("CITY NAME = " + cityName);
            System.out.println("DEST ID = " + destId);

            if (destId == null || destId.isBlank()) {
                return List.of();
            }
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

            System.out.println("HOTEL RESPONSE = " + response.body());

            return parseHotels(response.body());

        } catch (Exception e) {
            e.printStackTrace();
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

    for (JsonNode node : results) {

        HotelDTO hotel = new HotelDTO();

        hotel.setHotelName(
                node.path("hotel_name").asText()
        );

        hotel.setDescription(
                node.path("accommodation_type_name").asText("")
        );

        hotel.setAddress(
                node.path("address").asText()
        );

        double totalPrice = node.path("min_total_price").asDouble();

        hotel.setPrice(totalPrice);

        hotel.setPetFriendly(false);


        hotel.setId(
                node.path("hotel_id").asText()
        );

        hotel.setName(
                node.path("hotel_name").asText()
        );

        hotel.setLocation(
                node.path("city").asText("Paris")
        );

        hotel.setStars(
                node.path("class").asInt(3)
        );

        hotel.setPricePerNight(totalPrice);

        hotel.setTotalPrice(totalPrice);

        hotel.setNights(1);

        hotel.setCheckIn("2026-05-20");

        hotel.setCheckOut("2026-05-22");

        hotel.setAmenities(List.of());

        hotel.setRating(
                node.path("review_score").asDouble(4.0)
        );

        hotel.setReviews(
                node.path("review_nr").asInt(100)
        );

        hotel.setRoomType(
                node.path("accommodation_type_name")
                        .asText("Standard Room")
        );

        hotel.setImageIndex(
                hotels.size() % 5
        );

        hotel.setImageUrl(
                node.path("max_photo_url").asText(null)
        );

        hotels.add(hotel);
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

    private String getDestinationId(String cityName) {
        try {
            String url = "https://booking-com.p.rapidapi.com/v1/hotels/locations"
                    + "?name=" + cityName
                    + "&locale=en-gb";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("x-rapidapi-key", apiKey)
                    .header("x-rapidapi-host", apiHost)
                    .GET()
                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("LOCATION RESPONSE = " + response.body());

            JsonNode root = objectMapper.readTree(response.body());

            if (root.isArray() && root.size() > 0) {
                return root.get(0).path("dest_id").asText();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public String searchHotelsRaw(String cityName, String checkin, String checkout, int adults, int roomNumber) {
        try {
            String destId = getDestinationId(cityName);

            if (destId == null || destId.isBlank()) {
                return "{\"result\":[]}";
            }

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

            return response.body();

        } catch (Exception e) {
            e.printStackTrace();
            return "{\"result\":[]}";
        }
    }

}