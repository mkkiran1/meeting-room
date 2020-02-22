package com.slmanju.meetingroom.rooms.controller.impl;

import com.slmanju.meetingroom.core.SearchResult;
import com.slmanju.meetingroom.rooms.controller.RoomControllerSpec;
import com.slmanju.meetingroom.rooms.service.delegator.RoomServiceDelegator;
import com.slmanju.meetingroom.rooms.service.transfer.dto.RoomDto;
import com.slmanju.meetingroom.rooms.service.transfer.dto.RoomSearchRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@RequestMapping("/rooms")
@Controller
public class RoomController implements RoomControllerSpec {

  private final RoomServiceDelegator roomServiceDelegator;

  public RoomController(RoomServiceDelegator roomServiceDelegator) {
    this.roomServiceDelegator = roomServiceDelegator;
  }

  @Override
  public String showSaveForm(Model model) {
    model.addAttribute("roomDto", new RoomDto());
    return "rooms/save";
  }

  @Override
  public String search(RoomSearchRequest searchRequest, Model model) {
    searchRequest.setStart(0);
    searchRequest.setSize(10);

    SearchResult searchResult = roomServiceDelegator.search(searchRequest);

    model.addAttribute("rooms", searchResult.getData());

    return "rooms/list";
  }

  @Override
  public String getRoom(Long id, Model model) {
    RoomDto roomDto = roomServiceDelegator.findById(id);
    model.addAttribute("room", roomDto);
    return "rooms/update";
  }

  @Override
  public String createRoom(RoomDto roomDto) {
    roomServiceDelegator.saveRoom(roomDto);

    return "redirect:/rooms/search";
  }

  @Override
  public String updateRoom(RoomDto roomDto) {
    roomServiceDelegator.updateRoom(roomDto.getId(), roomDto);

    return "redirect:/rooms/search";
  }

  @Override
  public String deleteRoom(Long id) {
    roomServiceDelegator.deleteRoom(id);

    return "redirect:/rooms/search";
  }

}
