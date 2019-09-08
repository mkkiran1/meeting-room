package com.slmanju.meetingroom.bookings.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class BookingDto {

    private String id;

    private String bookDate;

    private String startTime;

    private String endTime;

}
