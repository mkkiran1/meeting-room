package com.slmanju.meetingroom.meetings.domain.repository;

import com.slmanju.meetingroom.meetings.domain.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting, String> {

}
