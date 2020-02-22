package com.slmanju.meetingroom.meetings.service.transfer.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Data
public class MeetingDto {

  private Long id;
  private String title;
  private String description;
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate meetingOn;
  @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
  private LocalTime startAt;
  @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
  private LocalTime endAt;
  private Long organiserId;
  private Long roomId;

}
