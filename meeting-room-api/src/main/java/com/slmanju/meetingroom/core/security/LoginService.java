package com.slmanju.meetingroom.core.security;

import java.util.Optional;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
public interface LoginService {

    String login(String username, String password);
    
    Optional<UserPrincipal> loadUserByJwt(String token);

}
