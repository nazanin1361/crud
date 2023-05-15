package com.isc.crud.service.impl;

import com.isc.crud.dto.BaseDto;
import com.isc.crud.entity.BaseEntity;
import com.isc.crud.exception.NotFoundException;
import com.isc.crud.service.BaseService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseServiceImpl<E extends BaseEntity, D extends BaseDto> implements BaseService<E, D> {

    @Override
    public D save(D dto) {
        E entity = getMapper().toEntity(dto);
        entity = getRepository().save(entity);
        return getMapper().toDto(entity);
    }

    @Override
    public D update(D dto) {
        findById(dto.getId());
        if (!dto.getVersion().equals(dto.getVersion()))
            throw new NotFoundException("not same version exception");
        return save(dto);
    }

    @Override
    public List<D> saveAll(List<D> dtoList) {
        return dtoList.
                stream().
                map(d -> getRepository().save(getMapper().toEntity(d))).
                map(e -> getMapper().toDto(e)).
                collect(Collectors.toList());
    }

    @Override
    public D findById(Long id) {
        E entity = getRepository().findById(id).orElseThrow(() -> new NotFoundException("not found exception"));
        return getMapper().toDto(entity);
    }

    @Override
    public List<D> findAll() {
        List<D> list = new ArrayList<>();
        getRepository().findAll().iterator().forEachRemaining(e -> list.add(getMapper().toDto(e)));
        return list;
    }

}

