package com.slmanju.meetingroom.meetings.service;

import com.slmanju.meetingroom.meetings.repository.entity.Meeting;
import com.slmanju.meetingroom.meetings.service.transfer.dto.MeetingDto;
import com.slmanju.meetingroom.meetings.service.transfer.dto.MeetingSearchRequest;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
public interface MeetingService {

  List<Meeting> findAll();

  Page<Meeting> search(MeetingSearchRequest searchRequest);

  Optional<Meeting> findById(Long id);

  Meeting saveMeeting(MeetingDto meetingDto);

  Meeting updateMeeting(MeetingDto meetingDto);

  void deleteMeeting(Long id);

}
