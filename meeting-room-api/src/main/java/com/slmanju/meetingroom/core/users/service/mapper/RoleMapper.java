package com.slmanju.meetingroom.core.users.service.mapper;

import com.slmanju.meetingroom.core.service.mapper.DataMapper;
import com.slmanju.meetingroom.core.users.domain.model.Role;
import com.slmanju.meetingroom.core.users.service.dto.RoleDto;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Component
public final class RoleMapper implements DataMapper<Role, RoleDto> {

    @Override
    public Supplier<Role> newModel() {
        return Role::new;
    }

    @Override
    public Supplier<RoleDto> newDto() {
        return RoleDto::new;
    }

}
