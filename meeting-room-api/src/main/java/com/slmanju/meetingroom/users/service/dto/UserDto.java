package com.slmanju.meetingroom.users.service.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {

	private static final long serialVersionUID = 1;

    private String id;

    private String firstName;

    private String lastName;

    private String email;

}
