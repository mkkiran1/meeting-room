package com.slmanju.meetingroom.meetings.service.mapper;

import com.slmanju.meetingroom.meetings.domain.model.Meeting;
import com.slmanju.meetingroom.meetings.service.dto.MeetingDto;
import com.slmanju.meetingroom.rooms.domain.model.Room;
import com.slmanju.meetingroom.rooms.service.RoomService;
import com.slmanju.meetingroom.rooms.service.dto.RoomDto;
import com.slmanju.meetingroom.rooms.service.mapper.RoomMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public final class MeetingMapper {

    private final RoomService roomService;
    private final RoomMapper roomMapper;

    public MeetingMapper(RoomService roomService, RoomMapper roomMapper) {
        this.roomService = roomService;
        this.roomMapper = roomMapper;
    }

    public MeetingDto toDto(Meeting model) {
        MeetingDto dto = new MeetingDto();
        BeanUtils.copyProperties(model, dto, "room", "user");

        Room room = model.getRoom();
        MeetingDto.Room roomDto = new MeetingDto.Room();
        roomDto.setId(room.getId());
        roomDto.setName(room.getName());

        dto.setRoom(roomDto);

        return dto;
    }

    public Meeting fromDto(MeetingDto dto) {
        Meeting model = new Meeting();
        BeanUtils.copyProperties(dto, model, "room", "user");

        RoomDto roomDto = roomService.findById(dto.getRoom().getId());
        model.setRoom(roomMapper.fromDto(roomDto));

        return model;
    }

    public void copy(MeetingDto from, MeetingDto to) {
        BeanUtils.copyProperties(from, to);
    }

    public List<MeetingDto> toDtos(List<Meeting> models) {
        return models.stream().map(this::toDto).collect(toList());
    }

}
