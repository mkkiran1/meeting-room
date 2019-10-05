package com.slmanju.meetingroom.rooms.service.mapper;

import com.slmanju.meetingroom.core.service.mapper.DataMapper;
import com.slmanju.meetingroom.rooms.domain.model.Room;
import com.slmanju.meetingroom.rooms.service.dto.RoomDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Component
public final class RoomMapper implements DataMapper<Room, RoomDto> {

    public RoomDto toDto(Room model) {
        RoomDto dto = new RoomDto();
        BeanUtils.copyProperties(model, dto);
        return dto;
    }

    public Room fromDto(RoomDto dto) {
        Room model = new Room();
        BeanUtils.copyProperties(dto, model);
        return model;
    }

}
