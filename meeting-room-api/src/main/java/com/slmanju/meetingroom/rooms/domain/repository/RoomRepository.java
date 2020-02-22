package com.slmanju.meetingroom.rooms.domain.repository;

import com.slmanju.meetingroom.rooms.domain.model.Room;
import com.slmanju.meetingroom.rooms.service.dto.RoomSearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
public interface RoomRepository extends JpaRepository<Room, String> {

    @Query("SELECT room FROM Room room")
    Page<Room> search(@Param("searchRequest") RoomSearchRequest searchRequest, Pageable pageable);

}
