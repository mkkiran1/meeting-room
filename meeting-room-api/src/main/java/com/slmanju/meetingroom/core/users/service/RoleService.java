package com.slmanju.meetingroom.core.users.service;

import com.slmanju.meetingroom.core.users.service.dto.PermissionDto;
import com.slmanju.meetingroom.core.users.service.dto.RoleDto;

import java.util.List;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
public interface RoleService {

    RoleDto save(RoleDto dto);

    RoleDto findById(String id);

    List<RoleDto> findAll();

    RoleDto update(String id, RoleDto dto);

    void deleteById(String id);

    List<PermissionDto> findPermissionsById(String id);

    List<PermissionDto> upsertPermissions(String id, List<String> permissionIds);

}
