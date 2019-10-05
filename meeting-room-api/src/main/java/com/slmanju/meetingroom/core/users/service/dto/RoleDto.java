package com.slmanju.meetingroom.core.users.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Data @NoArgsConstructor
public class RoleDto {

	private static final long serialVersionUID = 1;

    private String id;

    private String code;

    private String displayName;

}
