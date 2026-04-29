package com.cmpe131.travel.repository;
import com.cmpe131.travel.model.FlightReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FlightReservationRepository extends JpaRepository<FlightReservation, Long> {
    /*
    springboot data jpa handles implementation
    methods from JpaRepositoryL:
    save(x);
    findAll(x);
    finfById(x);
    deleteBy(Id);
    */
    List<FlightReservation> findByBookingId(Long bookingId);
}