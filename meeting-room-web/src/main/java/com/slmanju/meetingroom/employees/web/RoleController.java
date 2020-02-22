package com.slmanju.meetingroom.employees.web;

import com.slmanju.meetingroom.employees.service.transfer.dto.RoleDto;
import com.slmanju.meetingroom.employees.service.transfer.dto.RoleSearchRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
public interface RoleController {

  @GetMapping(value = "/search")
  String search(RoleSearchRequest searchRequest, Model model);

  @GetMapping(value = "/{id}")
  String showUpdateForm(@PathVariable("id") Long id, Model model);

  @GetMapping(value = "")
  String showSaveForm(Model model);

  @PostMapping(value = "/")
  String createRole(RoleDto role);

  @PostMapping(value = "/{id}/update")
  String updateRole(@PathVariable("id") Long id, RoleDto role);

  @GetMapping(value = "/{id}/delete")
  String deleteRole(@PathVariable("id") Long id);

}
