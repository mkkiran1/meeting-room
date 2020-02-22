package com.slmanju.meetingroom.employees.web.impl;

import com.slmanju.meetingroom.core.SearchResult;
import com.slmanju.meetingroom.employees.service.delegator.RoleServiceDelegator;
import com.slmanju.meetingroom.employees.service.transfer.dto.RoleDto;
import com.slmanju.meetingroom.employees.service.transfer.dto.RoleSearchRequest;
import com.slmanju.meetingroom.employees.service.transfer.view.RoleView;
import com.slmanju.meetingroom.employees.web.RoleController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@RequestMapping("/roles")
@Controller
public class RoleControllerImpl implements RoleController {

  private final RoleServiceDelegator roleServiceDelegator;

  public RoleControllerImpl(RoleServiceDelegator roleServiceDelegator) {
    this.roleServiceDelegator = roleServiceDelegator;
  }

  @Override
  public String search(RoleSearchRequest searchRequest, Model model) {
    searchRequest.setStart(0);
    searchRequest.setSize(10);

    SearchResult searchResult = roleServiceDelegator.search(searchRequest);
    model.addAttribute("role", searchResult.getData());

    return "roles/list";
  }

  @Override
  public String showSaveForm(Model model) {
    model.addAttribute("role", new RoleDto());

    return "roles/save";
  }

  @Override
  public String showUpdateForm(Long id, Model model) {
    RoleView role = roleServiceDelegator.findById(id);
    model.addAttribute("role", role);

    return "roles/update";
  }

  @Override
  public String createRole(RoleDto role) {
    roleServiceDelegator.saveRole(role);

    return "redirect:/roles/search";
  }

  @Override
  public String updateRole(Long id, RoleDto role) {
    roleServiceDelegator.updateRole(id, role);

    return "redirect:/roles/search";
  }

  @Override
  public String deleteRole(Long id) {
    roleServiceDelegator.deleteRole(id);

    return "redirect:/roles/search";
  }

}
