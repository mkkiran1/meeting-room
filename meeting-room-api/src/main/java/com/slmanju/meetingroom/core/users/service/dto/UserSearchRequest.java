package com.slmanju.meetingroom.core.users.service.dto;

import com.slmanju.meetingroom.core.service.dto.SearchRequest;
import lombok.Data;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Data
public class UserSearchRequest extends SearchRequest<UserDto> {

    private String firstName = "";

}
