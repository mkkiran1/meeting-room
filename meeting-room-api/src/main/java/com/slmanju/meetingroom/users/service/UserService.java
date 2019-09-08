package com.slmanju.meetingroom.users.service;

import com.slmanju.meetingroom.users.service.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto save(UserDto dto);

    UserDto findById(String id);

    List<UserDto> findAll();

    UserDto update(String id, UserDto dto);

    void deleteById(String id);

}
