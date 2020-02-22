package com.slmanju.meetingroom.employees.service.impl;

import com.slmanju.meetingroom.core.ResourceNotFoundException;
import com.slmanju.meetingroom.employees.repository.EmployeeRepository;
import com.slmanju.meetingroom.employees.repository.entity.Employee;
import com.slmanju.meetingroom.employees.repository.entity.Role;
import com.slmanju.meetingroom.employees.service.EmployeeService;
import com.slmanju.meetingroom.employees.service.RoleService;
import com.slmanju.meetingroom.employees.service.mapper.EmployeeMapper;
import com.slmanju.meetingroom.employees.service.transfer.dto.EmployeeDto;
import com.slmanju.meetingroom.employees.service.transfer.dto.EmployeeSearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Service
public class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeRepository employeeRepository;
  private final RoleService roleService;
  private final EmployeeMapper employeeMapper;

  public EmployeeServiceImpl(EmployeeRepository employeeRepository, RoleService roleService, EmployeeMapper employeeMapper) {
    this.employeeRepository = employeeRepository;
    this.roleService = roleService;
    this.employeeMapper = employeeMapper;
  }

  @Override
  public Page<Employee> search(EmployeeSearchRequest searchRequest) {
    Sort sort = Sort.by("id").ascending();
    PageRequest pageRequest = PageRequest.of(searchRequest.getStart(), searchRequest.getSize(), sort);

    return employeeRepository.search(searchRequest, pageRequest);
  }

  @Override
  public Optional<Employee> findById(Long id) {
    return employeeRepository.findById(id);
  }

  @Override
  public Employee saveEmployee(EmployeeDto employeeDto) {
    Employee employee = employeeMapper.toEntity(employeeDto);
    Role role = roleService.findById(employeeDto.getRoleId()).orElseThrow(ResourceNotFoundException.of("Role not found"));
    employee.setRole(role);

    return employeeRepository.save(employee);
  }

  @Override
  public Employee updateEmployee(EmployeeDto employeeDto) {
    Employee employee = findById(employeeDto.getId()).orElseThrow(ResourceNotFoundException.of("Employee not found"));
    Role role = roleService.findById(employeeDto.getRoleId()).orElseThrow(ResourceNotFoundException.of("Role not found"));

    Employee entity = employeeMapper.toUpdateEntity(employeeDto, employee, "username", "password");
    entity.setUsername(employee.getUsername());
    entity.setPassword(employee.getPassword());
    entity.setRole(role);

    return employeeRepository.save(entity);
  }

  @Override
  public void deleteEmployee(Long id) {
    employeeRepository.deleteById(id);
  }

}
