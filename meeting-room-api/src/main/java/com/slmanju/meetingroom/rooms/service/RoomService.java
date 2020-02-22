package com.slmanju.meetingroom.rooms.service;

import com.slmanju.meetingroom.core.service.dto.SearchResult;
import com.slmanju.meetingroom.rooms.service.dto.RoomDto;
import com.slmanju.meetingroom.rooms.service.dto.RoomSearchRequest;

import java.util.List;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
public interface RoomService {

    RoomDto save(RoomDto dto);

    RoomDto findById(String id);

    List<RoomDto> findAll();

    RoomDto update(String id, RoomDto dto);

    void deleteById(String id);

    SearchResult<RoomDto> search(RoomSearchRequest searchRequest);

}
