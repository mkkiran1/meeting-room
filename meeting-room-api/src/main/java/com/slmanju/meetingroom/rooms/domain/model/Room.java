package com.slmanju.meetingroom.rooms.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "room")
public class Room implements Serializable {

	private static final long serialVersionUID = 1;

    @Id
    @Column
    private String id;

    @Column(name = "room_name")
    private String name;

}
