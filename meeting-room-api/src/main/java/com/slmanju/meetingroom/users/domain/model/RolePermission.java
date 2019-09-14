package com.slmanju.meetingroom.users.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data @NoArgsConstructor
@Entity
@Table(name = "role_permission")
public class RolePermission implements Serializable {

	private static final long serialVersionUID = 1;

    @Id
    @Column
    private String id;

    @Column(name = "role_id")
    private String role;

    @Column(name = "permission_id")
    private String permission;

}
