package com.slmanju.meetingroom.core.users.service.mapper;

import com.slmanju.meetingroom.core.service.mapper.DataMapper;
import com.slmanju.meetingroom.core.users.domain.model.Role;
import com.slmanju.meetingroom.core.users.service.dto.RoleDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Component
public final class RoleMapper implements DataMapper<Role, RoleDto> {

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

}
