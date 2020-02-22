package com.slmanju.meetingroom.core.users.service.mapper;

import com.slmanju.meetingroom.core.service.mapper.DataMapper;
import com.slmanju.meetingroom.core.users.domain.model.User;
import com.slmanju.meetingroom.core.users.service.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Component
public final class UserMapper implements DataMapper<User, UserDto> {

    @Override
    public Supplier<User> newModel() {
        return User::new;
    }

    @Override
    public Supplier<UserDto> newDto() {
        return UserDto::new;
    }

}
