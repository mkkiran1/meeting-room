package com.slmanju.meetingroom.users.service.impl;

import com.slmanju.meetingroom.core.exception.ResourceNotFoundException;
import com.slmanju.meetingroom.users.domain.model.Role;
import com.slmanju.meetingroom.users.domain.repository.RoleRepository;
import com.slmanju.meetingroom.users.service.RoleService;
import com.slmanju.meetingroom.users.service.dto.RoleDto;
import com.slmanju.meetingroom.users.service.mapper.RoleMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
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

}
