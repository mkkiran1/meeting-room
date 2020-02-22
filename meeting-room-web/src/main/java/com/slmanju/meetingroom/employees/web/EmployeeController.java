package com.slmanju.meetingroom.employees.web;

import com.slmanju.meetingroom.employees.service.transfer.dto.EmployeeDto;
import com.slmanju.meetingroom.employees.service.transfer.dto.EmployeeSearchRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
public interface EmployeeController {

  @GetMapping(value = "/search")
  String search(EmployeeSearchRequest searchRequest, Model model);

  @GetMapping(value = "/{id}")
  String showUpdateForm(@PathVariable("id") Long id, Model model);

  @GetMapping(value = "")
  String showSaveForm(Model model);

  @PostMapping(value = "")
  String createEmployee(EmployeeDto employee);

  @PostMapping(value = "/update")
  String updateEmployee(EmployeeDto employee);

  @GetMapping(value = "/{id}/delete")
  String deleteEmployee(@PathVariable("id") Long id);

}
