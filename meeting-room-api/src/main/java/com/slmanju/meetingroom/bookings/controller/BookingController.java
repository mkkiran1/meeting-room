package com.slmanju.meetingroom.bookings.controller;

import com.slmanju.meetingroom.bookings.service.BookingService;
import com.slmanju.meetingroom.bookings.service.dto.BookingDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public List<BookingDto> findAll() {
        return bookingService.findAll();
    }

    @GetMapping("/{id}")
    public BookingDto findById(@PathVariable String id) {
        return bookingService.findById(id);
    }

    @PostMapping
    public BookingDto save(@RequestBody BookingDto bookingDto) {
        return bookingService.save(bookingDto);
    }

    @PutMapping("/{id}")
    public BookingDto update(@PathVariable String id, @RequestBody BookingDto bookingDto) {
        return bookingService.update(id, bookingDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        bookingService.deleteById(id);
    }

}
