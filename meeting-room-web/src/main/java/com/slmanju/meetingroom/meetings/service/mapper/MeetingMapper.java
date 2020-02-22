package com.slmanju.meetingroom.meetings.service.mapper;

import com.slmanju.meetingroom.core.EntityMapper;
import com.slmanju.meetingroom.meetings.repository.entity.Meeting;
import com.slmanju.meetingroom.meetings.service.transfer.dto.MeetingDto;
import com.slmanju.meetingroom.meetings.service.transfer.view.MeetingView;
import org.springframework.stereotype.Component;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Component
public class MeetingMapper implements EntityMapper<Meeting, MeetingDto, MeetingView> {

  @Override
  public Meeting entity() {
    return new Meeting();
  }

  @Override
  public MeetingDto dto() {
    return new MeetingDto();
  }

  @Override
  public MeetingView view() {
    return new MeetingView();
  }

}
