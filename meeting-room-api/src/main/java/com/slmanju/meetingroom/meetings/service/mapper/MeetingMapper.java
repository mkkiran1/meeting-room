package com.slmanju.meetingroom.meetings.service.mapper;

import com.slmanju.meetingroom.meetings.domain.model.Meeting;
import com.slmanju.meetingroom.meetings.service.dto.MeetingDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public final class MeetingMapper {

    public MeetingDto toDto(Meeting model) {
        MeetingDto dto = new MeetingDto();
        BeanUtils.copyProperties(model, dto);
        return dto;
    }

    public Meeting fromDto(MeetingDto dto) {
        Meeting model = new Meeting();
        BeanUtils.copyProperties(dto, model);
        return model;
    }

    public void copy(MeetingDto from, MeetingDto to) {
        BeanUtils.copyProperties(from, to);
    }

    public List<MeetingDto> toDtos(List<Meeting> models) {
        return models.stream().map(this::toDto).collect(toList());
    }

}
