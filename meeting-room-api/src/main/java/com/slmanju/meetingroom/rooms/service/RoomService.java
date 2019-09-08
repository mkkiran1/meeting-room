package com.slmanju.meetingroom.rooms.service;

import java.util.List;

import com.slmanju.meetingroom.rooms.service.dto.RoomDto;

public interface RoomService {

    RoomDto save(RoomDto dto);

    RoomDto findById(String id);

    List<RoomDto> findAll();

    RoomDto update(String id, RoomDto dto);

    void deleteById(String id);

}
