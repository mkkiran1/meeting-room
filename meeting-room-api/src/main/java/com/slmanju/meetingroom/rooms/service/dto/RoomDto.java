package com.slmanju.meetingroom.rooms.service.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class RoomDto implements Serializable {

	private static final long serialVersionUID = 1;

    private String id;

    private String name;

}
