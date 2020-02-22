package com.slmanju.meetingroom.core;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * This class holds search results.
 *
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Data
public class SearchResult {

  public static final int DEFAULT_SIZE = 20;

  private List<?> data;
  private long total;
  private long totalPages;
  private int start = 0;
  private int size = DEFAULT_SIZE;
  private boolean hasNext;
  private boolean hasPrevious;

  public static <E, D, V> SearchResult of(Page<E> page, EntityMapper<E, D, V> dataMapper) {
    SearchResult searchResult = new SearchResult();
    searchResult.setData(dataMapper.toViews(page.getContent()));
    searchResult.setTotal(page.getTotalElements());
    searchResult.setTotalPages(page.getTotalPages());
    searchResult.setSize(page.getSize());
    searchResult.setHasNext(page.hasNext());
    searchResult.setHasPrevious(page.hasPrevious());

    return searchResult;
  }

}
