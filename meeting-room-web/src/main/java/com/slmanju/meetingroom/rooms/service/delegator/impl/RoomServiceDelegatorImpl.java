package com.slmanju.meetingroom.rooms.service.delegator.impl;

import com.slmanju.meetingroom.core.SearchResult;
import com.slmanju.meetingroom.rooms.repository.entity.Room;
import com.slmanju.meetingroom.rooms.service.RoomService;
import com.slmanju.meetingroom.rooms.service.delegator.RoomServiceDelegator;
import com.slmanju.meetingroom.rooms.service.mapper.RoomMapper;
import com.slmanju.meetingroom.rooms.service.transfer.dto.RoomDto;
import com.slmanju.meetingroom.rooms.service.transfer.dto.RoomSearchRequest;
import com.slmanju.meetingroom.rooms.service.transfer.view.RoomView;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Service
public class RoomServiceDelegatorImpl implements RoomServiceDelegator {

  private final RoomService roomService;

  private final RoomMapper roomMapper;

  public RoomServiceDelegatorImpl(RoomService roomService, RoomMapper roomMapper) {
    this.roomService = roomService;
    this.roomMapper = roomMapper;
  }

  @Override
  public List<RoomView> findAll() {
    List<Room> rooms = roomService.findAll();
    return roomMapper.toViews(rooms);
  }

  public SearchResult search(RoomSearchRequest searchRequest) {
    return roomService.search(searchRequest);
  }

  public RoomDto findById(Long id) {
    Optional<Room> room = roomService.findById(id);

    return room.map(roomMapper::toDto).orElse(null);
  }

  public RoomDto saveRoom(RoomDto roomDto) {
    return roomMapper.toDto(roomService.saveRoom(roomDto));
  }

  public RoomDto updateRoom(Long id, RoomDto roomDto) {
    Room room = roomService.updateRoom(id, roomDto);

    return roomMapper.toDto(room);
  }

  public void deleteRoom(Long id) {
    roomService.deleteRoom(id);
  }

}
