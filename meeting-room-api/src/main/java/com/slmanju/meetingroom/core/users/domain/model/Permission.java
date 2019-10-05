package com.slmanju.meetingroom.core.users.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data @NoArgsConstructor
@Entity
@Table(name = "permissions")
public class Permission implements Serializable {

	private static final long serialVersionUID = 1;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "code")
    private String code;

    @Column(name = "display_name")
    private String displayName;

}
