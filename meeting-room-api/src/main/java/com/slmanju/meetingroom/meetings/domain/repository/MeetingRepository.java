package com.slmanju.meetingroom.meetings.domain.repository;

import com.slmanju.meetingroom.meetings.domain.model.Meeting;
import com.slmanju.meetingroom.meetings.service.dto.MeetingSearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MeetingRepository extends JpaRepository<Meeting, String> {

//    @Override
//    @Query("Select meeting From Meeting meeting LEFT JOIN fetch meeting.room")
//    List<Meeting> findAll();

    @Query("Select meeting From Meeting meeting")
//    @Query("Select meeting From Meeting meeting LEFT JOIN fetch meeting.room")
    Page<Meeting> search(@Param("searchRequest") MeetingSearchRequest searchRequest, Pageable pageable);

}
