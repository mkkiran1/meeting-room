package com.slmanju.meetingroom.employees.service.delegator.impl;

import com.slmanju.meetingroom.core.ResourceNotFoundException;
import com.slmanju.meetingroom.core.SearchResult;
import com.slmanju.meetingroom.employees.repository.entity.Role;
import com.slmanju.meetingroom.employees.service.RoleService;
import com.slmanju.meetingroom.employees.service.delegator.RoleServiceDelegator;
import com.slmanju.meetingroom.employees.service.mapper.RoleMapper;
import com.slmanju.meetingroom.employees.service.transfer.dto.RoleDto;
import com.slmanju.meetingroom.employees.service.transfer.dto.RoleSearchRequest;
import com.slmanju.meetingroom.employees.service.transfer.view.RoleView;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Service
public class RoleServiceDelegatorImpl implements RoleServiceDelegator {

  private final RoleService roleService;
  private final RoleMapper roleMapper;

  public RoleServiceDelegatorImpl(RoleService roleService, RoleMapper roleMapper) {
    this.roleService = roleService;
    this.roleMapper = roleMapper;
  }

  @Override
  public List<RoleView> findAll() {
    return roleMapper.toViews(roleService.findAll());
  }

  public SearchResult search(RoleSearchRequest searchRequest) {
    return SearchResult.of(roleService.search(searchRequest), roleMapper);
  }

  public RoleView findById(Long id) {
    Optional<Role> role = roleService.findById(id);

    return role.map(roleMapper::toView).orElseThrow(ResourceNotFoundException.of("Role not found"));
  }

  public RoleDto saveRole(RoleDto roleDto) {
    return roleMapper.toDto(roleService.saveRole(roleDto));
  }

  public RoleDto updateRole(Long id, RoleDto roleDto) {
    Role role = roleService.updateRole(id, roleDto);

    return roleMapper.toDto(role);
  }

  public void deleteRole(Long id) {
    roleService.deleteRole(id);
  }

}
