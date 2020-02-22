package com.slmanju.meetingroom.employees.service.mapper;

import com.slmanju.meetingroom.core.EntityMapper;
import com.slmanju.meetingroom.employees.repository.entity.Role;
import com.slmanju.meetingroom.employees.service.transfer.dto.RoleDto;
import com.slmanju.meetingroom.employees.service.transfer.view.RoleView;
import org.springframework.stereotype.Component;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Component
public class RoleMapper implements EntityMapper<Role, RoleDto, RoleView> {

  @Override
  public Role entity() {
    return new Role();
  }

  @Override
  public RoleDto dto() {
    return new RoleDto();
  }

  @Override
  public RoleView view() {
    return new RoleView();
  }

}
