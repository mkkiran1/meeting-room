package com.slmanju.meetingroom.meetings.service.mapper;

import com.slmanju.meetingroom.core.service.mapper.DataMapper;
import com.slmanju.meetingroom.meetings.domain.model.Meeting;
import com.slmanju.meetingroom.meetings.service.dto.MeetingDto;
import com.slmanju.meetingroom.rooms.domain.model.Room;
import com.slmanju.meetingroom.rooms.service.RoomService;
import com.slmanju.meetingroom.rooms.service.dto.RoomDto;
import com.slmanju.meetingroom.rooms.service.mapper.RoomMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Component
public final class MeetingMapper implements DataMapper<Meeting, MeetingDto> {

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

}
