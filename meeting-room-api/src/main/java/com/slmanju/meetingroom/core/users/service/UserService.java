package com.slmanju.meetingroom.core.users.service;

import com.slmanju.meetingroom.core.service.dto.SearchResult;
import com.slmanju.meetingroom.core.users.service.dto.RoleDto;
import com.slmanju.meetingroom.core.users.service.dto.UserDto;
import com.slmanju.meetingroom.core.users.service.dto.UserSearchRequest;

import java.util.List;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
public interface UserService {

    UserDto save(UserDto dto);

    UserDto findById(String id);

    List<UserDto> findAll();

    UserDto update(String id, UserDto dto);

    void deleteById(String id);

    SearchResult<UserDto> search(UserSearchRequest searchRequest);

    List<RoleDto> upsertRoles(String id, List<String> roleIds);

}
