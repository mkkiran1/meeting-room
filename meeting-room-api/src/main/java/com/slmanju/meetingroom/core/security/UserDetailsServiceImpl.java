package com.slmanju.meetingroom.core.security;

import com.slmanju.meetingroom.core.users.service.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("UserDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserDetailsServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.info("load user by username {}", username);
        if (!username.equals("manjula")) {
            throw new UsernameNotFoundException("not found");
        }
        String[] roles = { "ADMIN", "MANAGER" };
        UserDto userDto = new UserDto();
        userDto.setId(UUID.randomUUID().toString());
        userDto.setFirstName("Manjula");
        userDto.setLastName("Jayawardana");
        userDto.setUsername("manjula");
        userDto.setPassword(passwordEncoder.encode("password"));
//        userDto.setRoles(roles);
        return new UserPrincipal(userDto);
    }

}
