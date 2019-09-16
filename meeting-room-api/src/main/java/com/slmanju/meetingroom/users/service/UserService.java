package com.slmanju.meetingroom.users.service;

import com.slmanju.meetingroom.users.service.dto.RoleDto;
import com.slmanju.meetingroom.users.service.dto.UserDto;
import com.slmanju.meetingroom.users.service.dto.UserSearchRequest;
import com.slmanju.meetingroom.users.service.dto.UserSearchResult;

import java.util.List;

public interface UserService {

    UserDto save(UserDto dto);

    UserDto findById(String id);

    List<UserDto> findAll();

    UserDto update(String id, UserDto dto);

    void deleteById(String id);

    UserSearchResult search(UserSearchRequest searchRequest);

    List<RoleDto> upsertRoles(String id, List<String> roleIds);

}
