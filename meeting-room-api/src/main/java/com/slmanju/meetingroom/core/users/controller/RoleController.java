package com.slmanju.meetingroom.core.users.controller;

import com.slmanju.meetingroom.core.users.service.RoleService;
import com.slmanju.meetingroom.core.users.service.dto.PermissionDto;
import com.slmanju.meetingroom.core.users.service.dto.RoleDto;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Void> delete(@PathVariable String id) {
        roleService.deleteById(id);
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/permissions")
    public List<PermissionDto> findPermissions(@PathVariable String id) {
        return roleService.findPermissionsById(id);
    }

    @PutMapping("/{id}/permissions")
    public List<PermissionDto> addPermissions(@PathVariable String id, @RequestBody List<String> permissionIds) {
        return roleService.upsertPermissions(id, permissionIds);
    }

}
