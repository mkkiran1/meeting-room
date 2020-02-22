package com.slmanju.meetingroom.rooms.service.delegator;

import com.slmanju.meetingroom.core.SearchResult;
import com.slmanju.meetingroom.rooms.service.transfer.dto.RoomDto;
import com.slmanju.meetingroom.rooms.service.transfer.dto.RoomSearchRequest;
import com.slmanju.meetingroom.rooms.service.transfer.view.RoomView;

import java.util.List;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
public interface RoomServiceDelegator {

  List<RoomView> findAll();

  SearchResult search(RoomSearchRequest searchRequest);

  RoomDto findById(Long id);

  RoomDto saveRoom(RoomDto roomDto);

  RoomDto updateRoom(Long id, RoomDto roomDto);

  void deleteRoom(Long id);
}
