package com.isc.crud.service;

import com.isc.crud.dto.BaseDto;
import com.isc.crud.entity.BaseEntity;
import com.isc.crud.mapper.BaseMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BaseService<E extends BaseEntity, D extends BaseDto> {

    D save(D var1);

    D update(D dto);

    List<D> saveAll(List<D> var1);

    D findById(Long var1);

    boolean existsById(Long var1);

    List<D> findAll();

    List<D> findAllById(List<Long> var1);

    long count();

    void deleteById(Long var1);

    void delete(D var1);

    void deleteAll(List<? extends D> var1);

    void deleteAll();

    BaseMapper<E, D> getMapper();

    default JpaRepository<E, Long> getRepository() {
        throw new IllegalArgumentException("CRUD repository is not implemented!");
    }


}

