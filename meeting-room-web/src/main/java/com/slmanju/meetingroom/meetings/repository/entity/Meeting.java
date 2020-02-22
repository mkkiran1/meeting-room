package com.slmanju.meetingroom.meetings.repository.entity;

import com.slmanju.meetingroom.employees.repository.entity.Employee;
import com.slmanju.meetingroom.rooms.repository.entity.Room;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Data
@Entity
@Table(name = "meetings")
public class Meeting {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "title")
  private String title;
  @Column(name = "description")
  private String description;
  @Column(name = "meeting_on")
  private LocalDate meetingOn;
  @Column(name = "start_at")
  private LocalTime startAt;
  @Column(name = "end_at")
  private LocalTime endAt;
  @ManyToOne
  @JoinColumn(name = "organiser_id")
  private Employee organiser;
  @ManyToOne
  @JoinColumn(name = "room_id")
  private Room room;

}

