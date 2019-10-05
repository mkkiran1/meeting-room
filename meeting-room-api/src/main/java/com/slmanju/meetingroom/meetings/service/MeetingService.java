package com.slmanju.meetingroom.meetings.service;

import com.slmanju.meetingroom.core.service.dto.SearchResult;
import com.slmanju.meetingroom.meetings.service.dto.MeetingDto;
import com.slmanju.meetingroom.meetings.service.dto.MeetingSearchRequest;

import java.util.List;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
public interface MeetingService {

    MeetingDto save(MeetingDto dto);

    MeetingDto findById(String id);

    List<MeetingDto> findAll();

    MeetingDto update(String id, MeetingDto dto);

    void deleteById(String id);

    SearchResult<MeetingDto> search(MeetingSearchRequest searchRequest);

}
