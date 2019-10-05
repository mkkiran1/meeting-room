package com.slmanju.meetingroom.meetings.service.impl;

import com.slmanju.meetingroom.core.exception.ResourceNotFoundException;
import com.slmanju.meetingroom.core.service.dto.SearchResult;
import com.slmanju.meetingroom.meetings.domain.model.Meeting;
import com.slmanju.meetingroom.meetings.domain.repository.MeetingRepository;
import com.slmanju.meetingroom.meetings.service.MeetingService;
import com.slmanju.meetingroom.meetings.service.dto.MeetingDto;
import com.slmanju.meetingroom.meetings.service.dto.MeetingSearchRequest;
import com.slmanju.meetingroom.meetings.service.mapper.MeetingMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Transactional
@Service
public class MeetingServiceImpl implements MeetingService {

    private final MeetingRepository meetingRepository;
    private final MeetingMapper meetingMapper;

    public MeetingServiceImpl(MeetingRepository meetingRepository, MeetingMapper meetingMapper) {
        this.meetingRepository = meetingRepository;
        this.meetingMapper = meetingMapper;
    }

    @Override
    public MeetingDto save(MeetingDto meetingDto) {
        Meeting entity = meetingMapper.fromDto(meetingDto);
        Meeting meeting = meetingRepository.save(entity);
        return meetingMapper.toDto(meeting);
    }

    @Override
    public MeetingDto findById(String id) {
        Optional<Meeting> meeting = meetingRepository.findById(id);
        return meeting.map(meetingMapper::toDto).orElseThrow(() -> new ResourceNotFoundException(id, "Meeting not found"));
    }

    @Override
    public List<MeetingDto> findAll() {
        List<Meeting> meetings = meetingRepository.findAll();
        return meetingMapper.toDtos(meetings);
    }

    @Override
    public MeetingDto update(String id, MeetingDto meetingDto) {
        MeetingDto toUpdate = findById(id);
        meetingMapper.copy(meetingDto, toUpdate);
        meetingRepository.save(meetingMapper.fromDto(toUpdate));
        return toUpdate;
    }

    @Override
    public void deleteById(String id) {
        meetingRepository.deleteById(id);
    }

    @Override
    public SearchResult<MeetingDto> search(MeetingSearchRequest searchRequest) {
        PageRequest pageRequest = PageRequest.of(searchRequest.getStart(), searchRequest.getSize());

        Page<Meeting> page = meetingRepository.search(searchRequest, pageRequest);

        return SearchResult.of(page, meetingMapper);
    }

}
