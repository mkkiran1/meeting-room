package com.slmanju.meetingroom.users.service.mapper;

import com.slmanju.meetingroom.users.domain.model.User;
import com.slmanju.meetingroom.users.service.dto.UserDto;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public final class UserMapper {

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

    public List<UserDto> toDtos(List<User> models) {
        return models.stream().map(this::toDto).collect(Collectors.toList());
    }

}
