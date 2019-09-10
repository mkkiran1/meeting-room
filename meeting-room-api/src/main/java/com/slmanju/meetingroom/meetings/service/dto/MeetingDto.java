package com.slmanju.meetingroom.meetings.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class MeetingDto {

	private static final long serialVersionUID = 1;

    private String id;

    private String subject;

    private String notes;

    private String meetingDate;

    private String startTime;

    private String endTime;

}
