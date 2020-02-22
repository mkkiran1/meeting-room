package com.slmanju.meetingroom.rooms.service.mapper;

import com.slmanju.meetingroom.core.service.mapper.DataMapper;
import com.slmanju.meetingroom.rooms.domain.model.Room;
import com.slmanju.meetingroom.rooms.service.dto.RoomDto;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Component
public final class RoomMapper implements DataMapper<Room, RoomDto> {

    public Supplier<Room> newModel() {
        return Room::new;
    }

    public Supplier<RoomDto> newDto() {
        return RoomDto::new;
    }

}
