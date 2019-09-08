package com.slmanju.meetingroom.users.service.mapper;

import com.slmanju.meetingroom.users.domain.model.User;
import com.slmanju.meetingroom.users.service.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
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

    public void copy(UserDto from, UserDto to) {
        BeanUtils.copyProperties(from, to);
    }

    public List<UserDto> toDtos(List<User> models) {
        return models.stream().map(this::toDto).collect(toList());
    }

}
