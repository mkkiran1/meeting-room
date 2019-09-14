package com.slmanju.meetingroom.rooms.controller;

import com.slmanju.meetingroom.rooms.service.RoomService;
import com.slmanju.meetingroom.rooms.service.dto.RoomDto;
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
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<RoomDto> findAll() {
        return roomService.findAll();
    }

    @GetMapping("/{id}")
    public RoomDto findById(@PathVariable String id) {
        return roomService.findById(id);
    }

    @PostMapping
    public RoomDto save(@Valid @RequestBody RoomDto roomDto) {
        return roomService.save(roomDto);
    }

    @PutMapping("/{id}")
    public RoomDto update(@PathVariable String id, @Valid @RequestBody RoomDto roomDto) {
        return roomService.update(id, roomDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        roomService.deleteById(id);
    }

}
