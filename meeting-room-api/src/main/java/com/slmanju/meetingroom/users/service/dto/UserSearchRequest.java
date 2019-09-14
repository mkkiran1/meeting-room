package com.slmanju.meetingroom.users.service.dto;

import com.slmanju.meetingroom.core.service.dto.SearchRequest;
import lombok.Data;

@Data
public class UserSearchRequest extends SearchRequest<UserDto> {

    private String firstName = "";

}
