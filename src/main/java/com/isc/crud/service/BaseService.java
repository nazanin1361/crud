package com.isc.crud.service;

import com.isc.crud.dto.BaseDto;
import com.isc.crud.entity.BaseEntity;
import com.isc.crud.mapper.BaseMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BaseService<E extends BaseEntity, D extends BaseDto> {

    D save(D var1);

    D update(D dto);

    List<D> saveAll(List<D> var1);

    D findById(Long var1);

    List<D> findAll();

    BaseMapper<E, D> getMapper();

    default CrudRepository<E, Long> getRepository() {
        return getJpaRepository();
    }

    default <P extends JpaRepository<E, Long>> P getJpaRepository() {
        throw new IllegalArgumentException("CRUD repository is not implemented!");
    }


}

