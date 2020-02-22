package com.slmanju.meetingroom.core.users.service.mapper;

import com.slmanju.meetingroom.core.service.mapper.DataMapper;
import com.slmanju.meetingroom.core.users.domain.model.Permission;
import com.slmanju.meetingroom.core.users.service.dto.PermissionDto;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Component
public final class PermissionMapper implements DataMapper<Permission, PermissionDto> {

    @Override
    public Supplier<Permission> newModel() {
        return Permission::new;
    }

    @Override
    public Supplier<PermissionDto> newDto() {
        return PermissionDto::new;
    }

}
