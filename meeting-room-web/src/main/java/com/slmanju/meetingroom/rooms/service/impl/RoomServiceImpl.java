package com.slmanju.meetingroom.rooms.service.impl;

import com.slmanju.meetingroom.core.SearchResult;
import com.slmanju.meetingroom.rooms.repository.RoomRepository;
import com.slmanju.meetingroom.rooms.repository.entity.Room;
import com.slmanju.meetingroom.rooms.service.RoomService;
import com.slmanju.meetingroom.rooms.service.mapper.RoomMapper;
import com.slmanju.meetingroom.rooms.service.transfer.dto.RoomDto;
import com.slmanju.meetingroom.rooms.service.transfer.dto.RoomSearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Service
public class RoomServiceImpl implements RoomService {

  private final RoomRepository roomRepository;

  private final RoomMapper roomMapper;

  public RoomServiceImpl(RoomRepository roomRepository, RoomMapper roomMapper) {
    this.roomRepository = roomRepository;
    this.roomMapper = roomMapper;
  }

  @Override
  public List<Room> findAll() {
    return roomRepository.findAll();
  }

  @Override
  public SearchResult search(RoomSearchRequest searchRequest) {
    Sort sort = Sort.by("id").ascending();
    PageRequest pageRequest = PageRequest.of(searchRequest.getStart(), searchRequest.getSize(), sort);

    Page<Room> page = roomRepository.search(searchRequest, pageRequest);

    return SearchResult.of(page, roomMapper);
  }

  @Override
  public Optional<Room> findById(Long id) {
    return roomRepository.findById(id);
  }

  @Override
  public Room saveRoom(RoomDto roomDto) {
    Room room = roomMapper.toEntity(roomDto);

    return roomRepository.save(room);
  }

  @Override
  public Room updateRoom(Long id, RoomDto roomDto) {
    Optional<Room> roomOptional = findById(id);

    Room room = roomOptional.map(saved -> roomMapper.toUpdateEntity(roomDto, saved)).orElse(null);

    return roomRepository.save(room);
  }

  @Override
  public void deleteRoom(Long id) {
    roomRepository.deleteById(id);
  }

}
