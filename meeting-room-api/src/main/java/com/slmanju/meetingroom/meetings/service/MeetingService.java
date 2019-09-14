package com.slmanju.meetingroom.meetings.service;

import com.slmanju.meetingroom.meetings.service.dto.MeetingDto;
import com.slmanju.meetingroom.meetings.service.dto.MeetingSearchRequest;
import com.slmanju.meetingroom.meetings.service.dto.MeetingSearchResult;

import java.util.List;

public interface MeetingService {

    MeetingDto save(MeetingDto dto);

    MeetingDto findById(String id);

    List<MeetingDto> findAll();

    MeetingDto update(String id, MeetingDto dto);

    void deleteById(String id);

    MeetingSearchResult search(MeetingSearchRequest searchRequest);

}
