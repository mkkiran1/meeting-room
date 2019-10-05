package com.slmanju.meetingroom.core.service.mapper;

import org.springframework.beans.BeanUtils;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @param <S> Server model object
 * @param <R> Return dto object in rest api
 *
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 */
public interface DataMapper<S, R> {

    R toDto(S model);

    S fromDto(R dto);

    default void copy(R from, R to) {
        BeanUtils.copyProperties(from, to);
    }

    default List<R> toDtos(List<S> models) {
        return models.stream().map(this::toDto).collect(toList());
    }

    default List<S> fromDtos(List<R> dtos) {
        return dtos.stream().map(this::fromDto).collect(toList());
    }

}
