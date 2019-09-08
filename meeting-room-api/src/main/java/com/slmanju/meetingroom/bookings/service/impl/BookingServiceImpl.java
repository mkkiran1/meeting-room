package com.slmanju.meetingroom.bookings.service.impl;

import com.slmanju.meetingroom.bookings.domain.model.Booking;
import com.slmanju.meetingroom.bookings.domain.repository.BookingRepository;
import com.slmanju.meetingroom.bookings.service.BookingService;
import com.slmanju.meetingroom.bookings.service.dto.BookingDto;
import com.slmanju.meetingroom.bookings.service.mapper.BookingMapper;
import com.slmanju.meetingroom.core.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    public BookingServiceImpl(BookingRepository bookingRepository, BookingMapper bookingMapper) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
    }

    @Override
    public BookingDto save(BookingDto bookingDto) {
        Booking booking = bookingRepository.save(bookingMapper.fromDto(bookingDto));
        return bookingMapper.toDto(booking);
    }

    @Override
    public BookingDto findById(String id) {
        Optional<Booking> booking = bookingRepository.findById(id);
        return booking.map(bookingMapper::toDto).orElseThrow(() -> new ResourceNotFoundException(id, "Booking not found"));
    }

    @Override
    public List<BookingDto> findAll() {
        List<Booking> bookings = bookingRepository.findAll();
        return bookingMapper.toDtos(bookings);
    }

    @Override
    public BookingDto update(String id, BookingDto bookingDto) {
        BookingDto toUpdate = findById(id);
        bookingMapper.copy(bookingDto, toUpdate);
        bookingRepository.save(bookingMapper.fromDto(toUpdate));
        return toUpdate;
    }

    @Override
    public void deleteById(String id) {
        bookingRepository.deleteById(id);
    }

}
