package com.slmanju.meetingroom.meetings.controller;

import com.slmanju.meetingroom.meetings.service.MeetingService;
import com.slmanju.meetingroom.meetings.service.dto.MeetingDto;
import com.slmanju.meetingroom.meetings.service.dto.MeetingSearchRequest;
import com.slmanju.meetingroom.meetings.service.dto.MeetingSearchResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/meetings")
public class MeetingController {

    private final MeetingService meetingService;

    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @GetMapping
    public List<MeetingDto> findAll() {
        return meetingService.findAll();
    }

    @GetMapping("/{id}")
    public MeetingDto findById(@PathVariable String id) {
        return meetingService.findById(id);
    }

    @PostMapping
    public MeetingDto save(@Valid @RequestBody MeetingDto meetingDto) {
        return meetingService.save(meetingDto);
    }

    @PutMapping("/{id}")
    public MeetingDto update(@PathVariable String id, @Valid @RequestBody MeetingDto meetingDto) {
        return meetingService.update(id, meetingDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        meetingService.deleteById(id);
    }

    @GetMapping("/search/{start}/{size}")
    public MeetingSearchResult search(@PathVariable int start, @PathVariable int size, MeetingSearchRequest searchRequest) {
        searchRequest.setStart(start);
        searchRequest.setSize(size);
        return meetingService.search(searchRequest);
    }

}
