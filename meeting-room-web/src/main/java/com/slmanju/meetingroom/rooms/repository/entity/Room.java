package com.slmanju.meetingroom.rooms.repository.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Data
@Entity
@Table(name = "rooms")
public class Room {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "room_name")
  private String roomName;
}
