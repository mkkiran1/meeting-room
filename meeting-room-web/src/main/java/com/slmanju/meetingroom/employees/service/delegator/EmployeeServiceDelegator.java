package com.slmanju.meetingroom.employees.service.delegator;

import com.slmanju.meetingroom.core.SearchResult;
import com.slmanju.meetingroom.employees.service.transfer.dto.EmployeeDto;
import com.slmanju.meetingroom.employees.service.transfer.dto.EmployeeSearchRequest;
import com.slmanju.meetingroom.employees.service.transfer.view.EmployeeView;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
public interface EmployeeServiceDelegator {

  SearchResult search(EmployeeSearchRequest searchRequest);

  EmployeeView findById(Long id);

  EmployeeDto saveEmployee(EmployeeDto employeeDto);

  EmployeeDto updateEmployee(EmployeeDto employeeDto);

  void deleteEmployee(Long id);

}
