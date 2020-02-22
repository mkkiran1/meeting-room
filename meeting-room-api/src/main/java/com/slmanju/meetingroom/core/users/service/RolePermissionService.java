package com.slmanju.meetingroom.core.users.service;

import com.slmanju.meetingroom.core.users.service.dto.RolePermissionDto;

import java.util.List;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
public interface RolePermissionService {

    RolePermissionDto save(RolePermissionDto dto);

    RolePermissionDto findById(String id);

    List<RolePermissionDto> findAll();

    RolePermissionDto update(String id, RolePermissionDto dto);

    void deleteById(String id);

}
