package com.slmanju.meetingroom.users.controller;

import com.slmanju.meetingroom.users.service.RoleService;
import com.slmanju.meetingroom.users.service.dto.RoleDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public List<RoleDto> findAll() {
        return roleService.findAll();
    }

    @GetMapping("/{id}")
    public RoleDto findById(@PathVariable String id) {
        return roleService.findById(id);
    }

    @PostMapping
    public RoleDto save(@RequestBody RoleDto roleDto) {
        return roleService.save(roleDto);
    }

    @PutMapping("/{id}")
    public RoleDto update(@PathVariable String id, @RequestBody RoleDto roleDto) {
        return roleService.update(id, roleDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        roleService.deleteById(id);
    }

}
