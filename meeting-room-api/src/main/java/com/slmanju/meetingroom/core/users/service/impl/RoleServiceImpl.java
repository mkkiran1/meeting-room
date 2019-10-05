package com.slmanju.meetingroom.core.users.service.impl;

import com.slmanju.meetingroom.core.exception.ResourceNotFoundException;
import com.slmanju.meetingroom.core.users.domain.model.Permission;
import com.slmanju.meetingroom.core.users.domain.model.Role;
import com.slmanju.meetingroom.core.users.domain.model.RolePermission;
import com.slmanju.meetingroom.core.users.domain.repository.PermissionRepository;
import com.slmanju.meetingroom.core.users.domain.repository.RolePermissionRepository;
import com.slmanju.meetingroom.core.users.domain.repository.RoleRepository;
import com.slmanju.meetingroom.core.users.service.RoleService;
import com.slmanju.meetingroom.core.users.service.dto.PermissionDto;
import com.slmanju.meetingroom.core.users.service.dto.RoleDto;
import com.slmanju.meetingroom.core.users.service.mapper.PermissionMapper;
import com.slmanju.meetingroom.core.users.service.mapper.RoleMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.toList;

@Transactional
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    private final PermissionRepository permissionRepository;

    private final RolePermissionRepository rolePermissionRepository;

    private final RoleMapper roleMapper;

    private final PermissionMapper permissionMapper;

    public RoleServiceImpl(RoleRepository roleRepository,
                           PermissionRepository permissionRepository,
                           RolePermissionRepository rolePermissionRepository,
                           RoleMapper roleMapper,
                           PermissionMapper permissionMapper) {
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
        this.rolePermissionRepository = rolePermissionRepository;
        this.roleMapper = roleMapper;
        this.permissionMapper = permissionMapper;
    }

    @Override
    public RoleDto save(RoleDto roleDto) {
        Role role = roleRepository.save(roleMapper.fromDto(roleDto));
        return roleMapper.toDto(role);
    }

    @Override
    public RoleDto findById(String id) {
        Optional<Role> role = roleRepository.findById(id);
        return role.map(roleMapper::toDto).orElseThrow(() -> new ResourceNotFoundException(id, "Role not found"));
    }

    @Override
    public List<RoleDto> findAll() {
        List<Role> roles = roleRepository.findAll();
        return roleMapper.toDtos(roles);
    }

    @Override
    public RoleDto update(String id, RoleDto roleDto) {
        RoleDto toUpdate = findById(id);
        roleMapper.copy(roleDto, toUpdate);
        roleRepository.save(roleMapper.fromDto(toUpdate));
        return toUpdate;
    }

    @Override
    public void deleteById(String id) {
        roleRepository.deleteById(id);
    }

    @Override
    public List<PermissionDto> findPermissionsById(String id) {
        Set<RolePermission> rolePermissions = rolePermissionRepository.findByRoleId(id);

        List<Permission> permissions = rolePermissions.stream().map(RolePermission::getPermission).collect(toList());

        return permissionMapper.toDtos(permissions);
    }

    @Override
    public List<PermissionDto> upsertPermissions(String id, List<String> permissionIds) {
        List<Permission> permissions = permissionRepository.findByIdIn(permissionIds);

        rolePermissionRepository.deleteByRoleId(id);

        Role role = roleRepository.findById(id).get();

        List<RolePermission> rolePermissions = permissions.stream()
                .map(permission -> new RolePermission(role, permission))
                .collect(toList());

        rolePermissionRepository.saveAll(rolePermissions);

        return permissionMapper.toDtos(permissions);
    }

}
