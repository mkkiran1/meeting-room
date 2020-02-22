package com.slmanju.meetingroom.meetings.service.delegator;

import com.slmanju.meetingroom.core.SearchResult;
import com.slmanju.meetingroom.meetings.service.transfer.dto.MeetingDto;
import com.slmanju.meetingroom.meetings.service.transfer.dto.MeetingSearchRequest;
import com.slmanju.meetingroom.meetings.service.transfer.view.MeetingView;

import java.util.List;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
public interface MeetingServiceDelegator {

  List<MeetingDto> findAll();

  SearchResult search(MeetingSearchRequest searchRequest);

  MeetingView findById(Long id);

  MeetingDto saveMeeting(MeetingDto meetingDto);

  MeetingDto updateMeeting(MeetingDto meetingDto);

  void deleteMeeting(Long id);

}
