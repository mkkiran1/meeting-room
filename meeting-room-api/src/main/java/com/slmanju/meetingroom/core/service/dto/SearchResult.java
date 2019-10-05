package com.slmanju.meetingroom.core.service.dto;

import com.slmanju.meetingroom.core.service.mapper.DataMapper;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * This class holds search results.
 *
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
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

    /**
     * Create {@link SearchResult} using {@link Page} object.
     *
     * @param page {@link Page} object.
     * @param dataMapper {@link DataMapper} to convert data.
     * @param <T> Dto
     * @param <S> Model
     * @return {@link SearchResult} of {@link Page}
     */
    public static <T, S> SearchResult<T> of(Page<S> page, DataMapper<S, T> dataMapper) {
        SearchResult<T> searchResult = new SearchResult<>();
        searchResult.setContent(dataMapper.toDtos(page.getContent()));
        searchResult.setTotal(page.getTotalElements());
        searchResult.setTotalPages(page.getTotalPages());
        searchResult.setSize(page.getSize());
        searchResult.setHasNext(page.hasNext());
        searchResult.setHasPrevious(page.hasPrevious());
        return searchResult;
    }

}
