package com.isc.crud.service.impl;

import com.isc.crud.dto.BaseDto;
import com.isc.crud.entity.BaseEntity;
import com.isc.crud.service.BaseService;

import java.util.ArrayList;
import java.util.Collections;
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
        /*if (!dto.getVersion().equals(dbData.getVersion()))
            throw new InternalBusinessException("not same version exception");*/
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
        //E entity = getCrudRepository().findById(id).orElseThrow(() -> new InternalBusinessException("not found exception"));
        E entity = getRepository().findById(id).orElse(null);
        return getMapper().toDto(entity);
    }

    @Override
    public boolean existsById(Long var1) {
        return false;
    }

    @Override
    public List<D> findAll() {
        List<D> list = new ArrayList<>();
        getRepository().findAll().iterator().forEachRemaining(e -> list.add(getMapper().toDto(e)));
        return list;
    }

    @Override
    public List<D> findAllById(List<Long> var1) {
        return Collections.emptyList();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long var1) {

    }

    @Override
    public void delete(D var1) {

    }

    @Override
    public void deleteAll(List<? extends D> var1) {

    }

    @Override
    public void deleteAll() {

    }
}

