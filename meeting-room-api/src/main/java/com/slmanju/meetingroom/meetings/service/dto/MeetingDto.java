package com.slmanju.meetingroom.meetings.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data @NoArgsConstructor
public class MeetingDto {

	private static final long serialVersionUID = 1;

    private String id;

    @NotBlank(message = "Subject is required")
    private String subject;

    @NotBlank(message = "Notes is required")
    private String notes;

    @NotBlank(message = "Meeting date is required")
    private String meetingDate;

    @NotBlank(message = "Start time is required")
    private String startTime;

    @NotBlank(message = "End time is required")
    private String endTime;

    private Room room;

//    private User user;

    @Data @NoArgsConstructor
    public static class User {
        private String id;

        private String name;
    }

    @Data @NoArgsConstructor
    public static class Room {
        @NotBlank(message = "Room id is required")
        private String id;

        private String name;
    }

}
