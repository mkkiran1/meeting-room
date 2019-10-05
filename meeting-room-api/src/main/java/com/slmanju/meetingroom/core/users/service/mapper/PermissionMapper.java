package com.slmanju.meetingroom.core.users.service.mapper;

import com.slmanju.meetingroom.core.service.mapper.DataMapper;
import com.slmanju.meetingroom.core.users.domain.model.Permission;
import com.slmanju.meetingroom.core.users.service.dto.PermissionDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Component
public final class PermissionMapper implements DataMapper<Permission, PermissionDto> {

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

}
