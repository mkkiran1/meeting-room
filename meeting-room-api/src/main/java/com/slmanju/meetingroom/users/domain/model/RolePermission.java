package com.slmanju.meetingroom.users.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "role_permission")
public class RolePermission implements Serializable {

	private static final long serialVersionUID = 1;

    @EmbeddedId
    private RolePermissionId rolePermissionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("roleId")
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("permissionId")
    private Permission permission;

    public RolePermission() {

    }

    public RolePermission(Role role, Permission permission) {
        this.role = role;
        this.permission = permission;
        this.rolePermissionId = new RolePermissionId(role.getId(), permission.getId());
    }

    @Data @NoArgsConstructor @AllArgsConstructor
    @Embeddable
    public static class RolePermissionId implements Serializable {

        @Column(name = "roleId")
        private String roleId;

        @Column(name = "permissionId")
        private String permissionId;
    }

}
