package com.slmanju.meetingroom.employees.service;

import com.slmanju.meetingroom.employees.repository.entity.Employee;
import com.slmanju.meetingroom.employees.service.transfer.dto.EmployeeDto;
import com.slmanju.meetingroom.employees.service.transfer.dto.EmployeeSearchRequest;
import org.springframework.data.domain.Page;

import java.util.Optional;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
public interface EmployeeService {

  Page<Employee> search(EmployeeSearchRequest searchRequest);

  Optional<Employee> findById(Long id);

  Employee saveEmployee(EmployeeDto employeeDto);

  Employee updateEmployee(EmployeeDto employeeDto);

  void deleteEmployee(Long id);

}
