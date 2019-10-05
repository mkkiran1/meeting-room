package com.slmanju.meetingroom.core.security;

import com.slmanju.meetingroom.core.users.service.dto.UserDto;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

    private final AuthenticationManager authenticationManager;

    @Autowired
    public LoginServiceImpl(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public String login(String username, String password) {
        LOGGER.info("user attempting to sign in {}", username);
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        return JwtUtils.token(authentication);
    }

    @Override
    public Optional<UserPrincipal> loadUserByJwt(String token) {
        LOGGER.info("load user by jwt token");
        Claims claims = JwtUtils.parse(token);
        List<SimpleGrantedAuthority> roles = JwtUtils.getRoles(claims);
        String[] authorities = roles.stream().map(SimpleGrantedAuthority::getAuthority).toArray(String[]::new);

        UserDto userDto = new UserDto();
        userDto.setId(JwtUtils.getId(claims));
        userDto.setUsername(JwtUtils.getUsername(claims));
        userDto.setPassword("");
//        userDto.setRoles(authorities);

        return Optional.of(new UserPrincipal(userDto));
    }

}
