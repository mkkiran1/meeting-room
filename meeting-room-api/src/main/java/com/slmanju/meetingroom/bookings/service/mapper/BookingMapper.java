package com.slmanju.meetingroom.bookings.service.mapper;

import com.slmanju.meetingroom.bookings.domain.model.Booking;
import com.slmanju.meetingroom.bookings.service.dto.BookingDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public final class BookingMapper {

    public BookingDto toDto(Booking model) {
        BookingDto dto = new BookingDto();
        BeanUtils.copyProperties(model, dto);
        return dto;
    }

    public Booking fromDto(BookingDto dto) {
        Booking model = new Booking();
        BeanUtils.copyProperties(dto, model);
        return model;
    }

    public void copy(BookingDto from, BookingDto to) {
        BeanUtils.copyProperties(from, to);
    }

    public List<BookingDto> toDtos(List<Booking> models) {
        return models.stream().map(this::toDto).collect(toList());
    }

}
