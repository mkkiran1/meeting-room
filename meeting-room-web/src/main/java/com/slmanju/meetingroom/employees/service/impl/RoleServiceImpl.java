package com.slmanju.meetingroom.employees.service.impl;

import com.slmanju.meetingroom.employees.repository.RoleRepository;
import com.slmanju.meetingroom.employees.repository.entity.Role;
import com.slmanju.meetingroom.employees.service.RoleService;
import com.slmanju.meetingroom.employees.service.mapper.RoleMapper;
import com.slmanju.meetingroom.employees.service.transfer.dto.RoleDto;
import com.slmanju.meetingroom.employees.service.transfer.dto.RoleSearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Service
public class RoleServiceImpl implements RoleService {

  private final RoleRepository roleRepository;

  private final RoleMapper roleMapper;

  public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
    this.roleRepository = roleRepository;
    this.roleMapper = roleMapper;
  }

  @Override
  public List<Role> findAll() {
    return roleRepository.findAll();
  }

  @Override
  public Page<Role> search(RoleSearchRequest searchRequest) {
    Sort sort = Sort.by("id").ascending();
    PageRequest pageRequest = PageRequest.of(searchRequest.getStart(), searchRequest.getSize(), sort);

    return roleRepository.search(searchRequest, pageRequest);
  }

  @Override
  public Optional<Role> findById(Long id) {
    return roleRepository.findById(id);
  }

  @Override
  public Role saveRole(RoleDto roleDto) {
    Role role = roleMapper.toEntity(roleDto);

    return roleRepository.save(role);
  }

  @Override
  public Role updateRole(Long id, RoleDto roleDto) {
    Optional<Role> roleOptional = findById(id);

    Role role = roleOptional.map(saved -> roleMapper.toUpdateEntity(roleDto, saved)).orElse(null);

    return roleRepository.save(role);
  }

  @Override
  public void deleteRole(Long id) {
    roleRepository.deleteById(id);
  }

}
