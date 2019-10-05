package com.slmanju.meetingroom.core.users.service.impl;

import com.slmanju.meetingroom.core.exception.ResourceNotFoundException;
import com.slmanju.meetingroom.core.service.dto.SearchResult;
import com.slmanju.meetingroom.core.users.domain.model.Role;
import com.slmanju.meetingroom.core.users.domain.model.User;
import com.slmanju.meetingroom.core.users.domain.model.UserRole;
import com.slmanju.meetingroom.core.users.domain.repository.RoleRepository;
import com.slmanju.meetingroom.core.users.domain.repository.UserRepository;
import com.slmanju.meetingroom.core.users.domain.repository.UserRoleRepository;
import com.slmanju.meetingroom.core.users.service.UserService;
import com.slmanju.meetingroom.core.users.service.dto.RoleDto;
import com.slmanju.meetingroom.core.users.service.dto.UserDto;
import com.slmanju.meetingroom.core.users.service.dto.UserSearchRequest;
import com.slmanju.meetingroom.core.users.service.mapper.RoleMapper;
import com.slmanju.meetingroom.core.users.service.mapper.UserMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Transactional
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final UserRoleRepository userRoleRepository;

    private final UserMapper userMapper;

    private final RoleMapper roleMapper;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, UserRoleRepository userRoleRepository, UserMapper userMapper, RoleMapper roleMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userRoleRepository = userRoleRepository;
        this.userMapper = userMapper;
        this.roleMapper = roleMapper;
    }

    @Override
    public UserDto save(UserDto userDto) {
        User user = userRepository.save(userMapper.fromDto(userDto));
        return userMapper.toDto(user);
    }

    @Override
    public UserDto findById(String id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(userMapper::toDto).orElseThrow(() -> new ResourceNotFoundException(id, "User not found"));
    }

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        return userMapper.toDtos(users);
    }

    @Override
    public UserDto update(String id, UserDto userDto) {
        UserDto toUpdate = findById(id);
        userMapper.copy(userDto, toUpdate);
        userRepository.save(userMapper.fromDto(toUpdate));
        return toUpdate;
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public SearchResult<UserDto> search(UserSearchRequest searchRequest) {
        Sort sort = Sort.by("firstName").ascending();
        PageRequest pageRequest = PageRequest.of(searchRequest.getStart(), searchRequest.getSize(), sort);

        Page<User> page = userRepository.search(searchRequest, pageRequest);

        return SearchResult.of(page, userMapper);
    }

    @Override
    public List<RoleDto> upsertRoles(String id, List<String> roleIds) {
        List<Role> roles = roleRepository.findByIdIn(roleIds);

        userRoleRepository.deleteByUserId(id);

        User user = userRepository.findById(id).get();

        List<UserRole> rolePermissions = roles.stream()
                .map(role -> new UserRole(user, role))
                .collect(toList());

        userRoleRepository.saveAll(rolePermissions);

        return roleMapper.toDtos(roles);
    }

}
