package com.slmanju.meetingroom.meetings.web;

import com.slmanju.meetingroom.meetings.service.transfer.dto.MeetingDto;
import com.slmanju.meetingroom.meetings.service.transfer.dto.MeetingSearchRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
public interface MeetingController {

  @GetMapping(value = "/search")
  String search(MeetingSearchRequest searchRequest, Model model);

  @GetMapping(value = "/{id}")
  String showUpdateForm(@PathVariable("id") Long id, Model model);

  @GetMapping(value = "")
  String showSaveForm(Model model);

  @PostMapping(value = "")
  String createMeeting(MeetingDto meeting);

  @PostMapping(value = "/update")
  String updateMeeting(MeetingDto meeting);

  @GetMapping(value = "/{id}/delete")
  String deleteMeeting(@PathVariable("id") Long id);

}
