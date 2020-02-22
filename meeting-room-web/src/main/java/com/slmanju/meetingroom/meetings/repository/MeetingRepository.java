package com.slmanju.meetingroom.meetings.repository;

import com.slmanju.meetingroom.meetings.repository.entity.Meeting;
import com.slmanju.meetingroom.meetings.service.transfer.dto.MeetingSearchRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 */
public interface MeetingRepository extends JpaRepository<Meeting, Long> {

  @Query("SELECT meeting FROM Meeting meeting")
  Page<Meeting> search(@Param("searchRequest") MeetingSearchRequest searchRequest, Pageable pageable);

}
