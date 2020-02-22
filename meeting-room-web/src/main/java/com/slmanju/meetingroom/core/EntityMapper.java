package com.slmanju.meetingroom.core;

import org.springframework.beans.BeanUtils;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 */
public interface EntityMapper<E, D, V> {

  E entity();

  D dto();

  V view();

  default D toDto(E entity) {
    D dto = dto();
    BeanUtils.copyProperties(entity, dto);
    return dto;
  }

  default V toView(E entity) {
    V view = view();
    BeanUtils.copyProperties(entity, view);
    return view;
  }

  default E toEntity(D dto) {
    E entity = entity();
    BeanUtils.copyProperties(dto, entity);
    return entity;
  }

  default E toUpdateEntity(D dto, E entity, String... ignoreProperties) {
    BeanUtils.copyProperties(dto, entity, ignoreProperties);
    return entity;
  }

  default List<D> toDtos(List<E> entities) {
    return entities.stream().map(this::toDto).collect(toList());
  }

  default List<V> toViews(List<E> entities) {
    return entities.stream().map(this::toView).collect(toList());
  }

}
