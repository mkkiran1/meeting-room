package com.slmanju.meetingroom.users.service.impl;

import com.slmanju.meetingroom.core.exception.ResourceNotFoundException;
import com.slmanju.meetingroom.users.domain.model.RolePermission;
import com.slmanju.meetingroom.users.domain.repository.RolePermissionRepository;
import com.slmanju.meetingroom.users.service.RolePermissionService;
import com.slmanju.meetingroom.users.service.dto.RolePermissionDto;
import com.slmanju.meetingroom.users.service.mapper.RolePermissionMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    private final RolePermissionRepository rolePermissionRepository;
    private final RolePermissionMapper rolePermissionMapper;

    public RolePermissionServiceImpl(RolePermissionRepository rolePermissionRepository, RolePermissionMapper rolePermissionMapper) {
        this.rolePermissionRepository = rolePermissionRepository;
        this.rolePermissionMapper = rolePermissionMapper;
    }

    @Override
    public RolePermissionDto save(RolePermissionDto rolePermissionDto) {
        RolePermission rolePermission = rolePermissionRepository.save(rolePermissionMapper.fromDto(rolePermissionDto));
        return rolePermissionMapper.toDto(rolePermission);
    }

    @Override
    public RolePermissionDto findById(String id) {
        Optional<RolePermission> rolePermission = rolePermissionRepository.findById(id);
        return rolePermission.map(rolePermissionMapper::toDto).orElseThrow(() -> new ResourceNotFoundException(id, "RolePermission not found"));
    }

    @Override
    public List<RolePermissionDto> findAll() {
        List<RolePermission> rolePermissions = rolePermissionRepository.findAll();
        return rolePermissionMapper.toDtos(rolePermissions);
    }

    @Override
    public RolePermissionDto update(String id, RolePermissionDto rolePermissionDto) {
        RolePermissionDto toUpdate = findById(id);
        rolePermissionMapper.copy(rolePermissionDto, toUpdate);
        rolePermissionRepository.save(rolePermissionMapper.fromDto(toUpdate));
        return toUpdate;
    }

    @Override
    public void deleteById(String id) {
        rolePermissionRepository.deleteById(id);
    }

}
