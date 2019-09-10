package com.slmanju.meetingroom.meetings.controller;

import com.slmanju.meetingroom.meetings.service.MeetingService;
import com.slmanju.meetingroom.meetings.service.dto.MeetingDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public MeetingDto save(@RequestBody MeetingDto meetingDto) {
        return meetingService.save(meetingDto);
    }

    @PutMapping("/{id}")
    public MeetingDto update(@PathVariable String id, @RequestBody MeetingDto meetingDto) {
        return meetingService.update(id, meetingDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        meetingService.deleteById(id);
    }

}
