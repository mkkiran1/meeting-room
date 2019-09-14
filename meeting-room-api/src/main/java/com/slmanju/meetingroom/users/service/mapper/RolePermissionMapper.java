package com.slmanju.meetingroom.users.service.mapper;

import com.slmanju.meetingroom.users.domain.model.RolePermission;
import com.slmanju.meetingroom.users.service.dto.RolePermissionDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public final class RolePermissionMapper {

    public RolePermissionDto toDto(RolePermission model) {
        RolePermissionDto dto = new RolePermissionDto();
        BeanUtils.copyProperties(model, dto);
        return dto;
    }

    public RolePermission fromDto(RolePermissionDto dto) {
        RolePermission model = new RolePermission();
        BeanUtils.copyProperties(dto, model);
        return model;
    }

    public void copy(RolePermissionDto from, RolePermissionDto to) {
        BeanUtils.copyProperties(from, to);
    }

    public List<RolePermissionDto> toDtos(List<RolePermission> models) {
        return models.stream().map(this::toDto).collect(toList());
    }

}
