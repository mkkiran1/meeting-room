package com.slmanju.meetingroom.meetings.service.impl;

import com.slmanju.meetingroom.core.ResourceNotFoundException;
import com.slmanju.meetingroom.employees.repository.entity.Employee;
import com.slmanju.meetingroom.employees.service.EmployeeService;
import com.slmanju.meetingroom.meetings.repository.MeetingRepository;
import com.slmanju.meetingroom.meetings.repository.entity.Meeting;
import com.slmanju.meetingroom.meetings.service.MeetingService;
import com.slmanju.meetingroom.meetings.service.mapper.MeetingMapper;
import com.slmanju.meetingroom.meetings.service.transfer.dto.MeetingDto;
import com.slmanju.meetingroom.meetings.service.transfer.dto.MeetingSearchRequest;
import com.slmanju.meetingroom.rooms.repository.entity.Room;
import com.slmanju.meetingroom.rooms.service.RoomService;
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
public class MeetingServiceImpl implements MeetingService {

  private final MeetingRepository meetingRepository;
  private final MeetingMapper meetingMapper;
  private final EmployeeService employeeService;
  private final RoomService roomService;

  public MeetingServiceImpl(MeetingRepository meetingRepository,
                            MeetingMapper meetingMapper,
                            EmployeeService employeeService,
                            RoomService roomService) {
    this.meetingRepository = meetingRepository;
    this.meetingMapper = meetingMapper;
    this.employeeService = employeeService;
    this.roomService = roomService;
  }

  @Override
  public List<Meeting> findAll() {
    return meetingRepository.findAll();
  }

  @Override
  public Page<Meeting> search(MeetingSearchRequest searchRequest) {
    Sort sort = Sort.by("id").ascending();
    PageRequest pageRequest = PageRequest.of(searchRequest.getStart(), searchRequest.getSize(), sort);

    return  meetingRepository.search(searchRequest, pageRequest);
  }

  @Override
  public Optional<Meeting> findById(Long id) {
    return meetingRepository.findById(id);
  }

  @Override
  public Meeting saveMeeting(MeetingDto meetingDto) {
    Employee employee = employeeService.findById(meetingDto.getOrganiserId()).orElseThrow(ResourceNotFoundException.of("Employee not found"));
    Room room = roomService.findById(meetingDto.getRoomId()).orElseThrow(ResourceNotFoundException.of("Room not found"));

    Meeting entity = meetingMapper.toEntity(meetingDto);
    entity.setOrganiser(employee);
    entity.setRoom(room);

    return meetingRepository.save(entity);
  }

  @Override
  public Meeting updateMeeting(MeetingDto meetingDto) {
    Meeting meeting = findById(meetingDto.getId()).orElseThrow(ResourceNotFoundException.of("Meeting not found"));
    Employee employee = employeeService.findById(meetingDto.getOrganiserId()).orElseThrow(ResourceNotFoundException.of("Employee not found"));
    Room room = roomService.findById(meetingDto.getRoomId()).orElseThrow(ResourceNotFoundException.of("Room not found"));

    Meeting entity = meetingMapper.toUpdateEntity(meetingDto, meeting);
    entity.setOrganiser(employee);
    entity.setRoom(room);

    return meetingRepository.save(entity);
  }

  @Override
  public void deleteMeeting(Long id) {
    meetingRepository.deleteById(id);
  }

}
