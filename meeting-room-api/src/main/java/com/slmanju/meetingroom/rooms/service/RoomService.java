package com.slmanju.meetingroom.rooms.service;

import java.util.List;

import com.slmanju.meetingroom.rooms.service.dto.RoomDto;
import com.slmanju.meetingroom.rooms.service.dto.RoomSearchRequest;
import com.slmanju.meetingroom.rooms.service.dto.RoomSearchResult;

public interface RoomService {

    RoomDto save(RoomDto dto);

    RoomDto findById(String id);

    List<RoomDto> findAll();

    RoomDto update(String id, RoomDto dto);

    void deleteById(String id);

    RoomSearchResult search(RoomSearchRequest searchRequest);

}
