package com.slmanju.meetingroom.meetings.service;

import com.slmanju.meetingroom.meetings.service.dto.MeetingDto;

import java.util.List;

public interface MeetingService {

    MeetingDto save(MeetingDto dto);

    MeetingDto findById(String id);

    List<MeetingDto> findAll();

    MeetingDto update(String id, MeetingDto dto);

    void deleteById(String id);

}
