package com.slmanju.meetingroom.users.service.impl;

import com.slmanju.meetingroom.core.exception.ResourceNotFoundException;
import com.slmanju.meetingroom.users.domain.model.User;
import com.slmanju.meetingroom.users.domain.repository.UserRepository;
import com.slmanju.meetingroom.users.service.UserService;
import com.slmanju.meetingroom.users.service.dto.UserDto;
import com.slmanju.meetingroom.users.service.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
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

}
