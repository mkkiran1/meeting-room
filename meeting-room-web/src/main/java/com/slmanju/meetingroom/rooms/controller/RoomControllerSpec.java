package com.slmanju.meetingroom.rooms.controller;

import com.slmanju.meetingroom.rooms.service.transfer.dto.RoomDto;
import com.slmanju.meetingroom.rooms.service.transfer.dto.RoomSearchRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
public interface RoomControllerSpec {

  @GetMapping(value = "")
  String showSaveForm(Model model);

  @GetMapping(value = "/search")
  String search(RoomSearchRequest searchRequest, Model model);

  @GetMapping(value = "/{id}")
  String getRoom(@PathVariable("id") Long id, Model model);

  @PostMapping(value = "")
  String createRoom(RoomDto roomDto);

  @PostMapping(value = "/update")
  String updateRoom(RoomDto roomDto);

  @GetMapping(value = "/delete/{id}")
  String deleteRoom(@PathVariable("id") Long id);

}
