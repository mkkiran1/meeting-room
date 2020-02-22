package com.slmanju.meetingroom.employees.service.delegator;

import com.slmanju.meetingroom.core.SearchResult;
import com.slmanju.meetingroom.employees.service.transfer.dto.RoleDto;
import com.slmanju.meetingroom.employees.service.transfer.dto.RoleSearchRequest;
import com.slmanju.meetingroom.employees.service.transfer.view.RoleView;

import java.util.List;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
public interface RoleServiceDelegator {

  List<RoleView> findAll();

  SearchResult search(RoleSearchRequest searchRequest);

  RoleView findById(Long id);

  RoleDto saveRole(RoleDto roleDto);

  RoleDto updateRole(Long id, RoleDto roleDto);

  void deleteRole(Long id);
}
