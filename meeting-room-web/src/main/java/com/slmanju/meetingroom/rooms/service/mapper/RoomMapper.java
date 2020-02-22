package com.slmanju.meetingroom.rooms.service.mapper;

import com.slmanju.meetingroom.core.EntityMapper;
import com.slmanju.meetingroom.rooms.repository.entity.Room;
import com.slmanju.meetingroom.rooms.service.transfer.dto.RoomDto;
import com.slmanju.meetingroom.rooms.service.transfer.view.RoomView;
import org.springframework.stereotype.Component;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Component
public class RoomMapper implements EntityMapper<Room, RoomDto, RoomView> {

  @Override
  public Room entity() {
    return new Room();
  }

  @Override
  public RoomDto dto() {
    return new RoomDto();
  }

  @Override
  public RoomView view() {
    return new RoomView();
  }

}
