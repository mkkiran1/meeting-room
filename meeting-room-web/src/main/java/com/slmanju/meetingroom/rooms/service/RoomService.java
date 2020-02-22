package com.slmanju.meetingroom.rooms.service;

import com.slmanju.meetingroom.core.SearchResult;
import com.slmanju.meetingroom.rooms.repository.entity.Room;
import com.slmanju.meetingroom.rooms.service.transfer.dto.RoomDto;
import com.slmanju.meetingroom.rooms.service.transfer.dto.RoomSearchRequest;

import java.util.List;
import java.util.Optional;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
public interface RoomService {

  List<Room> findAll();

  SearchResult search(RoomSearchRequest searchRequest);

  Optional<Room> findById(Long id);

  Room saveRoom(RoomDto roomDto);

  Room updateRoom(Long id, RoomDto roomDto);

  void deleteRoom(Long id);
}
