package com.cmpe131.travel.repository;

import com.cmpe131.travel.model.HotelReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelReservationRepository extends JpaRepository<HotelReservation, Long> {
    /*
     * Spring Data JPA handles implementation.
     * Inherited methods from JpaRepository:
     * save(x);
     * findAll();
     * findById(x);
     * deleteById(x);
     */
    List<HotelReservation> findByBookingId(Long bookingId);
}