package com.slmanju.meetingroom.core.service.dto;

import lombok.Data;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Data
public class SearchRequest<T> {

    public static final int DEFAULT_SIZE = 20;

    private int start;

    private int end;

    private int size = DEFAULT_SIZE;

}
