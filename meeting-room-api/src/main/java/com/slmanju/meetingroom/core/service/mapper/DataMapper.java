package com.slmanju.meetingroom.core.service.mapper;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.function.Supplier;

import static java.util.stream.Collectors.toList;

/**
 * @param <S> Model object
 * @param <R> Dto object
 *
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 */
public interface DataMapper<S, R> {

    /**
     * Create dto object from model object.
     *
     * @param model Model object.
     * @return Dto Object.
     */
    default R toDto(S model) {
        R dto = newDto().get();
        BeanUtils.copyProperties(model, dto);
        return dto;
    }

    /**
     * Create model object from dto object.
     *
     * @param dto Dto object.
     * @return Model object.
     */
    default S fromDto(R dto) {
        S model = newModel().get();
        BeanUtils.copyProperties(dto, model);
        return model;
    }

    /**
     * Supply new model.
     *
     * @return Model supplier.
     */
    Supplier<S> newModel();

    /**
     * Supply new dto.
     *
     * @return Dto supplier.
     */
    Supplier<R> newDto();

    /**
     * Copy dto object into another dto object.
     *
     * @param from From dto.
     * @param to To dto.
     */
    default void copy(R from, R to) {
        BeanUtils.copyProperties(from, to);
    }

    /**
     * Create list of dtos of using list of models.
     *
     * @param models List of models.
     * @return List of dtos.
     */
    default List<R> toDtos(List<S> models) {
        return models.stream().map(this::toDto).collect(toList());
    }

    /**
     * Create list of models using list of dtos.
     *
     * @param dtos List of dtos.
     * @return List of models.
     */
    default List<S> fromDtos(List<R> dtos) {
        return dtos.stream().map(this::fromDto).collect(toList());
    }

}
