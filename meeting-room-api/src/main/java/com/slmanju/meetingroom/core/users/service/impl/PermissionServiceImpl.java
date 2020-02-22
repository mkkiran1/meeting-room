package com.slmanju.meetingroom.core.users.service.impl;

import com.slmanju.meetingroom.core.exception.ResourceNotFoundException;
import com.slmanju.meetingroom.core.users.domain.model.Permission;
import com.slmanju.meetingroom.core.users.domain.repository.PermissionRepository;
import com.slmanju.meetingroom.core.users.service.PermissionService;
import com.slmanju.meetingroom.core.users.service.dto.PermissionDto;
import com.slmanju.meetingroom.core.users.service.mapper.PermissionMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Transactional
@Service
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;
    private final PermissionMapper permissionMapper;

    public PermissionServiceImpl(PermissionRepository permissionRepository, PermissionMapper permissionMapper) {
        this.permissionRepository = permissionRepository;
        this.permissionMapper = permissionMapper;
    }

    @Override
    public PermissionDto save(PermissionDto permissionDto) {
        Permission permission = permissionRepository.save(permissionMapper.fromDto(permissionDto));
        return permissionMapper.toDto(permission);
    }

    @Override
    public PermissionDto findById(String id) {
        Optional<Permission> permission = permissionRepository.findById(id);
        return permission.map(permissionMapper::toDto).orElseThrow(() -> new ResourceNotFoundException(id, "Permission not found"));
    }

    @Override
    public List<PermissionDto> findAll() {
        List<Permission> permissions = permissionRepository.findAll();
        return permissionMapper.toDtos(permissions);
    }

    @Override
    public PermissionDto update(String id, PermissionDto permissionDto) {
        PermissionDto toUpdate = findById(id);
        permissionMapper.copy(permissionDto, toUpdate);
        permissionRepository.save(permissionMapper.fromDto(toUpdate));
        return toUpdate;
    }

    @Override
    public void deleteById(String id) {
        permissionRepository.deleteById(id);
    }

}
