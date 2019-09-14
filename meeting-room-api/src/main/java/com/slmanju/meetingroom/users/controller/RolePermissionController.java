package com.slmanju.meetingroom.users.controller;

import com.slmanju.meetingroom.users.service.RolePermissionService;
import com.slmanju.meetingroom.users.service.dto.RolePermissionDto;
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
@RequestMapping("/rolePermissions")
public class RolePermissionController {

    private final RolePermissionService rolePermissionService;

    public RolePermissionController(RolePermissionService rolePermissionService) {
        this.rolePermissionService = rolePermissionService;
    }

    @GetMapping
    public List<RolePermissionDto> findAll() {
        return rolePermissionService.findAll();
    }

    @GetMapping("/{id}")
    public RolePermissionDto findById(@PathVariable String id) {
        return rolePermissionService.findById(id);
    }

    @PostMapping
    public RolePermissionDto save(@RequestBody RolePermissionDto rolePermissionDto) {
        return rolePermissionService.save(rolePermissionDto);
    }

    @PutMapping("/{id}")
    public RolePermissionDto update(@PathVariable String id, @RequestBody RolePermissionDto rolePermissionDto) {
        return rolePermissionService.update(id, rolePermissionDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        rolePermissionService.deleteById(id);
    }

}
