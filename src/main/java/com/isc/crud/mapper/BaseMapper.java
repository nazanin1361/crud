package com.isc.crud.mapper;

import com.isc.crud.dto.BaseDto;
import com.isc.crud.entity.BaseEntity;

import java.util.List;

public interface BaseMapper<E extends BaseEntity, D extends BaseDto> {

    D toDto(E entity);

    E toEntity(D dto);

    List<D> toDtoList(List<E> entityList);

    List<E> toEntityList(List<D> dtoList);

}

