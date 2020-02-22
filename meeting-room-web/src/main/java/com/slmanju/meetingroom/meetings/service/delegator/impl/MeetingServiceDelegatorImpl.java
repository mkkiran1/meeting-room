package com.slmanju.meetingroom.meetings.service.delegator.impl;

import com.slmanju.meetingroom.core.ResourceNotFoundException;
import com.slmanju.meetingroom.core.SearchResult;
import com.slmanju.meetingroom.employees.service.mapper.EmployeeMapper;
import com.slmanju.meetingroom.employees.service.transfer.view.EmployeeView;
import com.slmanju.meetingroom.meetings.repository.entity.Meeting;
import com.slmanju.meetingroom.meetings.service.MeetingService;
import com.slmanju.meetingroom.meetings.service.delegator.MeetingServiceDelegator;
import com.slmanju.meetingroom.meetings.service.mapper.MeetingMapper;
import com.slmanju.meetingroom.meetings.service.transfer.dto.MeetingDto;
import com.slmanju.meetingroom.meetings.service.transfer.dto.MeetingSearchRequest;
import com.slmanju.meetingroom.meetings.service.transfer.view.MeetingView;
import com.slmanju.meetingroom.rooms.service.mapper.RoomMapper;
import com.slmanju.meetingroom.rooms.service.transfer.view.RoomView;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Service
public class MeetingServiceDelegatorImpl implements MeetingServiceDelegator {

  private final MeetingService meetingService;
  private final MeetingMapper meetingMapper;
  private final EmployeeMapper employeeMapper;
  private final RoomMapper roomMapper;

  public MeetingServiceDelegatorImpl(MeetingService meetingService,
                                     MeetingMapper meetingMapper,
                                     EmployeeMapper employeeMapper,
                                     RoomMapper roomMapper) {
    this.meetingService = meetingService;
    this.meetingMapper = meetingMapper;
    this.employeeMapper = employeeMapper;
    this.roomMapper = roomMapper;
  }

  @Override
  public List<MeetingDto> findAll() {
    return meetingMapper.toDtos(meetingService.findAll());
  }

  public SearchResult search(MeetingSearchRequest searchRequest) {
    return SearchResult.of(meetingService.search(searchRequest), meetingMapper);
  }

  public MeetingView findById(Long id) {
    Optional<Meeting> meeting = meetingService.findById(id);

    return meeting.map(entity -> {
      MeetingView meetingView = meetingMapper.toView(entity);
      EmployeeView employeeView = employeeMapper.toView(entity.getOrganiser());
      RoomView roomView = roomMapper.toView(entity.getRoom());
      meetingView.setOrganiser(employeeView);
      meetingView.setRoom(roomView);
      return meetingView;
    }).orElseThrow(ResourceNotFoundException.of("Meeting not found"));
  }

  public MeetingDto saveMeeting(MeetingDto meetingDto) {
    return meetingMapper.toDto(meetingService.saveMeeting(meetingDto));
  }

  public MeetingDto updateMeeting(MeetingDto meetingDto) {
    Meeting meeting = meetingService.updateMeeting(meetingDto);

    return meetingMapper.toDto(meeting);
  }

  public void deleteMeeting(Long id) {
    meetingService.deleteMeeting(id);
  }

}
