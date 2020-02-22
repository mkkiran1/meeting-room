package com.slmanju.meetingroom.employees.service;

import com.slmanju.meetingroom.employees.repository.entity.Role;
import com.slmanju.meetingroom.employees.service.transfer.dto.RoleDto;
import com.slmanju.meetingroom.employees.service.transfer.dto.RoleSearchRequest;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
public interface RoleService {

  List<Role> findAll();

  Page<Role> search(RoleSearchRequest searchRequest);

  Optional<Role> findById(Long id);

  Role saveRole(RoleDto roleDto);

  Role updateRole(Long id, RoleDto roleDto);

  void deleteRole(Long id);

}
