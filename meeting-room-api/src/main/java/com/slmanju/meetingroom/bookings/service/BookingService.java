package com.slmanju.meetingroom.bookings.service;

import com.slmanju.meetingroom.bookings.service.dto.BookingDto;

import java.util.List;

public interface BookingService {

    BookingDto save(BookingDto dto);

    BookingDto findById(String id);

    List<BookingDto> findAll();

    BookingDto update(String id, BookingDto dto);

    void deleteById(String id);

}
