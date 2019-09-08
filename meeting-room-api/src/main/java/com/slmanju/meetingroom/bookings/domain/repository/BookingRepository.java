package com.slmanju.meetingroom.bookings.domain.repository;

import com.slmanju.meetingroom.bookings.domain.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, String> {

}
