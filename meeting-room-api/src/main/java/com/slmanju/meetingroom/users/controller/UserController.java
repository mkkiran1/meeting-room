package com.slmanju.meetingroom.users.controller;

import com.slmanju.meetingroom.users.service.UserService;
import com.slmanju.meetingroom.users.service.dto.RoleDto;
import com.slmanju.meetingroom.users.service.dto.UserDto;
import com.slmanju.meetingroom.users.service.dto.UserSearchRequest;
import com.slmanju.meetingroom.users.service.dto.UserSearchResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable String id) {
        return userService.findById(id);
    }

    @PostMapping
    public UserDto save(@Valid @RequestBody UserDto userDto) {
        return userService.save(userDto);
    }

    @PutMapping("/{id}")
    public UserDto update(@PathVariable String id, @Valid @RequestBody UserDto userDto) {
        return userService.update(id, userDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        userService.deleteById(id);
    }

    @GetMapping("/search/{start}/{size}")
    public UserSearchResult search(@PathVariable int start, @PathVariable int size, UserSearchRequest searchRequest) {
        searchRequest.setStart(start);
        searchRequest.setSize(size);
        return userService.search(searchRequest);
    }

    @PutMapping("/{id}/roles")
    public List<RoleDto> addRoles(@PathVariable String id, @RequestBody List<String> roleIds) {
        return userService.upsertRoles(id, roleIds);
    }

    @GetMapping("/populate")
    public void populate() {
        IntStream.rangeClosed(1, 25).forEach(i -> {
            UserDto dto = new UserDto();
            dto.setFirstName("Name" + i);
            dto.setLastName("Last" + i);
            dto.setEmail("email" + 1 + "@email.com");
            userService.save(dto);
        });
    }

}
