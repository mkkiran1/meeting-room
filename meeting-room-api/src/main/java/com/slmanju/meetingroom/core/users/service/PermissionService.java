package com.slmanju.meetingroom.core.users.service;

import com.slmanju.meetingroom.core.users.service.dto.PermissionDto;

import java.util.List;

public interface PermissionService {

    PermissionDto save(PermissionDto dto);

    PermissionDto findById(String id);

    List<PermissionDto> findAll();

    PermissionDto update(String id, PermissionDto dto);

    void deleteById(String id);

}
