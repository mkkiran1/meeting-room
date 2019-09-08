package com.slmanju.meetingroom.rooms.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slmanju.meetingroom.rooms.domain.model.Room;

public interface RoomRepository extends JpaRepository<Room, String> {

}
