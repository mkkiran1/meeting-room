package com.slmanju.meetingroom.core.users.service.mapper;

import com.slmanju.meetingroom.core.service.mapper.DataMapper;
import com.slmanju.meetingroom.core.users.domain.model.User;
import com.slmanju.meetingroom.core.users.service.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public final class UserMapper implements DataMapper<User, UserDto> {

    public UserDto toDto(User model) {
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(model, dto);
        return dto;
    }

    public User fromDto(UserDto dto) {
        User model = new User();
        BeanUtils.copyProperties(dto, model);
        return model;
    }

}
