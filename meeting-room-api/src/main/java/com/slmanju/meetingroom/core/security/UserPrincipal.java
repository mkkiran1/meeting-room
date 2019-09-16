package com.slmanju.meetingroom.core.security;

import com.slmanju.meetingroom.users.service.dto.UserDto;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;

public class UserPrincipal extends User {

    private String id;
    private String fullname;
//    private String[] roles;

    // User(String username, String password, Collection<? extends GrantedAuthority> authorities)
    public UserPrincipal(UserDto userDto) {
        super(userDto.getUsername(), userDto.getPassword(), new ArrayList<>());
        this.id = userDto.getId();
        this.fullname = userDto.getFirstName() + " " + userDto.getLastName();
//        this.roles = userDto.getRoles();
    }

    public String getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

//    public String[] getRoles() {
//        return roles;
//    }

}
