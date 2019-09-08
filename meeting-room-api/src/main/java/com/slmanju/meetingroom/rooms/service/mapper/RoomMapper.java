package com.slmanju.meetingroom.rooms.service.mapper;

import com.slmanju.meetingroom.rooms.domain.model.Room;
import com.slmanju.meetingroom.rooms.service.dto.RoomDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public final class RoomMapper {

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

    public List<RoomDto> toDtos(List<Room> models) {
        return models.stream().map(this::toDto).collect(Collectors.toList());
    }

}
