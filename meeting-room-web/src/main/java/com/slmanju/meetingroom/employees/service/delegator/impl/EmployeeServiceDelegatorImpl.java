package com.slmanju.meetingroom.employees.service.delegator.impl;

import com.slmanju.meetingroom.core.ResourceNotFoundException;
import com.slmanju.meetingroom.core.SearchResult;
import com.slmanju.meetingroom.employees.repository.entity.Employee;
import com.slmanju.meetingroom.employees.service.EmployeeService;
import com.slmanju.meetingroom.employees.service.delegator.EmployeeServiceDelegator;
import com.slmanju.meetingroom.employees.service.mapper.EmployeeMapper;
import com.slmanju.meetingroom.employees.service.mapper.RoleMapper;
import com.slmanju.meetingroom.employees.service.transfer.dto.EmployeeDto;
import com.slmanju.meetingroom.employees.service.transfer.dto.EmployeeSearchRequest;

import com.slmanju.meetingroom.employees.service.transfer.dto.RoleDto;
import com.slmanju.meetingroom.employees.service.transfer.view.EmployeeView;
import com.slmanju.meetingroom.employees.service.transfer.view.RoleView;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Service
public class EmployeeServiceDelegatorImpl implements EmployeeServiceDelegator {

  private final EmployeeService employeeService;
  private final EmployeeMapper employeeMapper;
  private final RoleMapper roleMapper;

  public EmployeeServiceDelegatorImpl(EmployeeService employeeService,
                                      EmployeeMapper employeeMapper,
                                      RoleMapper roleMapper) {
    this.employeeService = employeeService;
    this.employeeMapper = employeeMapper;
    this.roleMapper = roleMapper;
  }

  public SearchResult search(EmployeeSearchRequest searchRequest) {
    return SearchResult.of(employeeService.search(searchRequest), employeeMapper);
  }

  public EmployeeView findById(Long id) {
    Optional<Employee> employee = employeeService.findById(id);
    return employee.map(entity -> {
      EmployeeView employeeView = employeeMapper.toView(entity);
      RoleView roleView = roleMapper.toView(entity.getRole());
      employeeView.setRole(roleView);
      return employeeView;
    }).orElseThrow(ResourceNotFoundException.of("Employee not found"));
  }

  public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
    return employeeMapper.toDto(employeeService.saveEmployee(employeeDto));
  }

  public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
    Employee employee = employeeService.updateEmployee(employeeDto);

    return employeeMapper.toDto(employee);
  }

  public void deleteEmployee(Long id) {
    employeeService.deleteEmployee(id);
  }

}
