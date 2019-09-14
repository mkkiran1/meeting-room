package com.slmanju.meetingroom.rooms.service.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class RoomDto implements Serializable {

	private static final long serialVersionUID = 1;

    private String id;

    @NotBlank(message = "Room name is required")
    private String name;

}
