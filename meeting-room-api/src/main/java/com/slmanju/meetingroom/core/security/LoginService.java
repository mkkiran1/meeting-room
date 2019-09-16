package com.slmanju.meetingroom.core.security;

import java.util.Optional;

public interface LoginService {

    String login(String username, String password);
    
    Optional<UserPrincipal> loadUserByJwt(String token);

}
