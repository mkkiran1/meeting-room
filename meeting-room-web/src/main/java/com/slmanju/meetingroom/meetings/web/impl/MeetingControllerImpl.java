package com.slmanju.meetingroom.meetings.web.impl;

import com.slmanju.meetingroom.core.SearchResult;
import com.slmanju.meetingroom.meetings.service.delegator.MeetingServiceDelegator;
import com.slmanju.meetingroom.meetings.service.transfer.dto.MeetingDto;
import com.slmanju.meetingroom.meetings.service.transfer.dto.MeetingSearchRequest;
import com.slmanju.meetingroom.meetings.service.transfer.view.MeetingView;
import com.slmanju.meetingroom.meetings.web.MeetingController;
import com.slmanju.meetingroom.rooms.service.delegator.RoomServiceDelegator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@RequestMapping("/meetings")
@Controller
public class MeetingControllerImpl implements MeetingController {

  private final MeetingServiceDelegator meetingServiceDelegator;
  private final RoomServiceDelegator roomServiceDelegator;

  public MeetingControllerImpl(MeetingServiceDelegator meetingServiceDelegator, RoomServiceDelegator roomServiceDelegator) {
    this.meetingServiceDelegator = meetingServiceDelegator;
    this.roomServiceDelegator = roomServiceDelegator;
  }

  @Override
  public String search(MeetingSearchRequest searchRequest, Model model) {
    searchRequest.setStart(0);
    searchRequest.setSize(10);

    SearchResult searchDto = meetingServiceDelegator.search(searchRequest);
    model.addAttribute("meetings", searchDto.getData());

    return "meetings/list";
  }

  @Override
  public String showSaveForm(Model model) {
    model.addAttribute("meeting", new MeetingDto());
    model.addAttribute("rooms", roomServiceDelegator.findAll());

    return "meetings/save";
  }

  @Override
  public String showUpdateForm(Long id, Model model) {
    MeetingView meeting = meetingServiceDelegator.findById(id);
    model.addAttribute("meeting", meeting);
    model.addAttribute("rooms", roomServiceDelegator.findAll());

    return "meetings/update";
  }

  @Override
  public String createMeeting(MeetingDto meeting) {
    meetingServiceDelegator.saveMeeting(meeting);

    return "redirect:/meetings/search";
  }

  @Override
  public String updateMeeting(MeetingDto meeting) {
    meetingServiceDelegator.updateMeeting(meeting);

    return "redirect:/meetings/search";
  }

  @Override
  public String deleteMeeting(Long id) {
    meetingServiceDelegator.deleteMeeting(id);

    return "redirect:/meetings/search";
  }

}
