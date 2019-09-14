package com.slmanju.meetingroom.users.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class PermissionDto {

	private static final long serialVersionUID = 1;

    private String id;

    private String code;

    private String displayName;

}
