package com.slmanju.meetingroom.meetings.service.transfer.view;

import com.slmanju.meetingroom.employees.service.transfer.view.EmployeeView;
import com.slmanju.meetingroom.rooms.service.transfer.view.RoomView;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Data
public class MeetingView {

  private Long id;
  private String title;
  private String description;
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate meetingOn;
  @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
  private LocalTime startAt;
  @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
  private LocalTime endAt;
  private EmployeeView organiser;
  private RoomView room;

}
