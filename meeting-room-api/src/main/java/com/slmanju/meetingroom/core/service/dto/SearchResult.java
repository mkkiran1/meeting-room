package com.slmanju.meetingroom.core.service.dto;

import lombok.Data;

import java.util.List;

@Data
public class SearchResult<T> {

    public static final int DEFAULT_SIZE = 20;

    private List<T> content;

    private long total;

    private long totalPages;

    private int start;

    private int size;

    private boolean hasNext;

    private boolean hasPrevious;

}
