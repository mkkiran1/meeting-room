package com.slmanju.meetingroom.employees.service.mapper;

import com.slmanju.meetingroom.core.EntityMapper;
import com.slmanju.meetingroom.employees.repository.entity.Employee;
import com.slmanju.meetingroom.employees.service.transfer.dto.EmployeeDto;
import com.slmanju.meetingroom.employees.service.transfer.view.EmployeeView;
import org.springframework.stereotype.Component;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Component
public class EmployeeMapper implements EntityMapper<Employee, EmployeeDto, EmployeeView> {

  @Override
  public Employee entity() {
    return new Employee();
  }

  @Override
  public EmployeeDto dto() {
    return new EmployeeDto();
  }

  @Override
  public EmployeeView view() {
    return new EmployeeView();
  }

}
