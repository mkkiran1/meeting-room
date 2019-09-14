package com.slmanju.meetingroom.users.service.mapper;

import com.slmanju.meetingroom.users.domain.model.Role;
import com.slmanju.meetingroom.users.service.dto.RoleDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public final class RoleMapper {

    public RoleDto toDto(Role model) {
        RoleDto dto = new RoleDto();
        BeanUtils.copyProperties(model, dto);
        return dto;
    }

    public Role fromDto(RoleDto dto) {
        Role model = new Role();
        BeanUtils.copyProperties(dto, model);
        return model;
    }

    public void copy(RoleDto from, RoleDto to) {
        BeanUtils.copyProperties(from, to);
    }

    public List<RoleDto> toDtos(List<Role> models) {
        return models.stream().map(this::toDto).collect(toList());
    }

}
