package com.slmanju.meetingroom.rooms.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.slmanju.meetingroom.rooms.domain.model.Room;
import com.slmanju.meetingroom.rooms.domain.repository.RoomRepository;
import com.slmanju.meetingroom.rooms.service.RoomService;
import com.slmanju.meetingroom.rooms.service.dto.RoomDto;
import com.slmanju.meetingroom.rooms.service.mapper.RoomMapper;

@Transactional
@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    public RoomServiceImpl(RoomRepository roomRepository, RoomMapper roomMapper) {
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
    }

    @Override
    public RoomDto save(RoomDto roomDto) {
        Room room = roomRepository.save(roomMapper.fromDto(roomDto));
        return roomMapper.toDto(room);
    }

    @Override
    public RoomDto findById(String id) {
        Optional<Room> room = roomRepository.findById(id);
        return room.map(roomMapper::toDto).orElseThrow(() -> new RuntimeException("Room not found"));
    }

    @Override
    public List<RoomDto> findAll() {
        List<Room> rooms = roomRepository.findAll();
        return roomMapper.toDtos(rooms);
    }

    @Override
    public RoomDto update(String id, RoomDto roomDto) {
        RoomDto toUpdate = findById(id);
        roomMapper.copy(roomDto, toUpdate);
        roomRepository.save(roomMapper.fromDto(toUpdate));
        return toUpdate;
    }

    @Override
    public void deleteById(String id) {
        roomRepository.deleteById(id);
    }

}
