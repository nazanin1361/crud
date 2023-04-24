package com.isc.crud.mapper;

import com.isc.crud.dto.CustomerDto;
import com.isc.crud.entity.Customer;
import org.mapstruct.*;

@Mapper(config = MapperConfiguration.class)
public interface CustomerMapper extends BaseMapper<Customer, CustomerDto> {
}
