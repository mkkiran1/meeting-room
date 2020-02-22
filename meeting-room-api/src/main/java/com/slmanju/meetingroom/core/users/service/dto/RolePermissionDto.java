package com.slmanju.meetingroom.core.users.service.dto;

import com.slmanju.meetingroom.core.users.domain.model.Permission;
import com.slmanju.meetingroom.core.users.domain.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Data
public class RolePermissionDto {

	private static final long serialVersionUID = 1;


    private RolePermissionDto.RolePermissionId rolePermissionId;

    private Role role;

    private Permission permission;

    public RolePermissionDto() {

    }

    public RolePermissionDto(Role role, Permission permission) {
        this.role = role;
        this.permission = permission;
        this.rolePermissionId = new RolePermissionDto.RolePermissionId(role.getId(), permission.getId());
    }

    @Data @NoArgsConstructor @AllArgsConstructor
    public static class RolePermissionId implements Serializable {

        private String role;

        private String permission;
    }

}
