package com.slmanju.meetingroom.core.users.controller;

import com.slmanju.meetingroom.core.users.service.PermissionService;
import com.slmanju.meetingroom.core.users.service.dto.PermissionDto;
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
@RequestMapping("/permissions")
public class PermissionController {

    private final PermissionService permissionService;

    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @GetMapping
    public List<PermissionDto> findAll() {
        return permissionService.findAll();
    }

    @GetMapping("/{id}")
    public PermissionDto findById(@PathVariable String id) {
        return permissionService.findById(id);
    }

    @PostMapping
    public PermissionDto save(@RequestBody PermissionDto permissionDto) {
        return permissionService.save(permissionDto);
    }

    @PutMapping("/{id}")
    public PermissionDto update(@PathVariable String id, @RequestBody PermissionDto permissionDto) {
        return permissionService.update(id, permissionDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        permissionService.deleteById(id);
    }

}
