package com.slmanju.meetingroom.core.security;

import com.slmanju.meetingroom.core.users.service.dto.UserDto;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
public class UserPrincipal extends User {

    private String id;
    private String firstName;
    private String lastName;
    private String fullname;
    private List<String> roles;

    // User(String username, String password, Collection<? extends GrantedAuthority> authorities)
    public UserPrincipal(UserDto userDto) {
        super(userDto.getUsername(), userDto.getPassword(), new ArrayList<>());
        this.id = userDto.getId();
        this.fullname = userDto.getFirstName() + " " + userDto.getLastName();
        this.firstName = userDto.getFirstName();
        this.lastName = userDto.getLastName();
        this.roles = userDto.getRoles();
    }

    public String getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<String> getRoles() {
        return roles;
    }

}
