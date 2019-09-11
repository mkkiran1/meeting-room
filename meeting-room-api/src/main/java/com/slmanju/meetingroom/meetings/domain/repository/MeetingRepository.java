package com.slmanju.meetingroom.meetings.domain.repository;

import com.slmanju.meetingroom.meetings.domain.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MeetingRepository extends JpaRepository<Meeting, String> {

    @Override
    @Query("Select meeting From Meeting meeting LEFT JOIN fetch meeting.room")
    List<Meeting> findAll();

}
