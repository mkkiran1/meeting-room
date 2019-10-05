package com.slmanju.meetingroom.core.users.service.mapper;

import com.slmanju.meetingroom.core.users.domain.model.Permission;
import com.slmanju.meetingroom.core.users.service.dto.PermissionDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public final class PermissionMapper {

    public PermissionDto toDto(Permission model) {
        PermissionDto dto = new PermissionDto();
        BeanUtils.copyProperties(model, dto);
        return dto;
    }

    public Permission fromDto(PermissionDto dto) {
        Permission model = new Permission();
        BeanUtils.copyProperties(dto, model);
        return model;
    }

    public void copy(PermissionDto from, PermissionDto to) {
        BeanUtils.copyProperties(from, to);
    }

    public List<PermissionDto> toDtos(List<Permission> models) {
        return models.stream().map(this::toDto).collect(toList());
    }

}
