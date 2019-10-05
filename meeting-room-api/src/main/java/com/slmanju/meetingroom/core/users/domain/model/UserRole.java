package com.slmanju.meetingroom.core.users.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Data
@Entity
@Table(name = "user_role")
public class UserRole implements Serializable {

	private static final long serialVersionUID = 1;

    @EmbeddedId
    private UserRoleId userRoleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("roleId")
    private Role role;

    public UserRole() {

    }

    public UserRole(User user, Role role) {
        this.role = role;
        this.user = user;
        this.userRoleId = new UserRoleId(user.getId(), role.getId());
    }

    @Data @NoArgsConstructor @AllArgsConstructor
    @Embeddable
    public static class UserRoleId implements Serializable {

        @Column(name = "userId")
        private String userId;

        @Column(name = "roleId")
        private String roleId;
    }

}
