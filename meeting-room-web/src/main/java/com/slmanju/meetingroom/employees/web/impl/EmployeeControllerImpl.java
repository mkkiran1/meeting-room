package com.slmanju.meetingroom.employees.web.impl;

import com.slmanju.meetingroom.core.SearchResult;
import com.slmanju.meetingroom.employees.service.delegator.EmployeeServiceDelegator;
import com.slmanju.meetingroom.employees.service.delegator.RoleServiceDelegator;
import com.slmanju.meetingroom.employees.service.transfer.dto.EmployeeDto;
import com.slmanju.meetingroom.employees.service.transfer.dto.EmployeeSearchRequest;
import com.slmanju.meetingroom.employees.service.transfer.view.EmployeeView;
import com.slmanju.meetingroom.employees.service.transfer.view.RoleView;
import com.slmanju.meetingroom.employees.web.EmployeeController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Slf4j
@RequestMapping("/employees")
@Controller
public class EmployeeControllerImpl implements EmployeeController {

  private final EmployeeServiceDelegator employeeServiceDelegator;
  private final RoleServiceDelegator roleServiceDelegator;

  public EmployeeControllerImpl(EmployeeServiceDelegator employeeServiceDelegator, RoleServiceDelegator roleServiceDelegator) {
    this.employeeServiceDelegator = employeeServiceDelegator;
    this.roleServiceDelegator = roleServiceDelegator;
  }

  @Override
  public String search(EmployeeSearchRequest searchRequest, Model model) {
    searchRequest.setStart(0);
    searchRequest.setSize(10);

    SearchResult searchResult = employeeServiceDelegator.search(searchRequest);
    model.addAttribute("employees", searchResult.getData());

    return "employees/list";
  }

  @Override
  public String showSaveForm(Model model) {
    List<RoleView> roles = roleServiceDelegator.findAll();
    model.addAttribute("employee", new EmployeeDto());
    model.addAttribute("roles", roles);

    return "employees/save";
  }

  @Override
  public String showUpdateForm(Long id, Model model) {
    EmployeeView employee = employeeServiceDelegator.findById(id);
    List<RoleView> roles = roleServiceDelegator.findAll();

    model.addAttribute("employee", employee);
    model.addAttribute("roles", roles);

    return "employees/update";
  }

  @Override
  public String createEmployee(EmployeeDto employee) {
    employeeServiceDelegator.saveEmployee(employee);

    return "redirect:/employees/search";
  }

  @Override
  public String updateEmployee(EmployeeDto employee) {
    employeeServiceDelegator.updateEmployee(employee);

    return "redirect:/employees/search";
  }

  @Override
  public String deleteEmployee(Long id) {
    employeeServiceDelegator.deleteEmployee(id);

    return "redirect:/employees/search";
  }

}
