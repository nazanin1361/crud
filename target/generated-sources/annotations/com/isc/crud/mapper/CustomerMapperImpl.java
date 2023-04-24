package com.isc.crud.mapper;

import com.isc.crud.dto.CustomerDto;
import com.isc.crud.dto.CustomerDto.CustomerDtoBuilder;
import com.isc.crud.entity.Customer;
import com.isc.crud.entity.Customer.CustomerBuilder;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-24T15:42:11+0330",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDto toDto(Customer entity) {
        if ( entity == null ) {
            return null;
        }

        CustomerDtoBuilder<?, ?> customerDto = CustomerDto.builder();

        if ( entity.getId() != null ) {
            customerDto.id( entity.getId() );
        }
        if ( entity.getUpdateDate() != null ) {
            customerDto.updateDate( entity.getUpdateDate() );
        }
        if ( entity.getCreateDate() != null ) {
            customerDto.createDate( entity.getCreateDate() );
        }
        if ( entity.getVersion() != null ) {
            customerDto.version( entity.getVersion() );
        }
        if ( entity.getName() != null ) {
            customerDto.name( entity.getName() );
        }
        if ( entity.getFamily() != null ) {
            customerDto.family( entity.getFamily() );
        }
        if ( entity.getNationalIdentifier() != null ) {
            customerDto.nationalIdentifier( entity.getNationalIdentifier() );
        }
        if ( entity.getBirthDate() != null ) {
            customerDto.birthDate( entity.getBirthDate() );
        }
        if ( entity.getPostalCode() != null ) {
            customerDto.postalCode( entity.getPostalCode() );
        }
        if ( entity.getAddress() != null ) {
            customerDto.address( entity.getAddress() );
        }
        if ( entity.getMobileNumber() != null ) {
            customerDto.mobileNumber( entity.getMobileNumber() );
        }
        if ( entity.getPersonalEmail() != null ) {
            customerDto.personalEmail( entity.getPersonalEmail() );
        }

        return customerDto.build();
    }

    @Override
    public Customer toEntity(CustomerDto dto) {
        if ( dto == null ) {
            return null;
        }

        CustomerBuilder<?, ?> customer = Customer.builder();

        if ( dto.getId() != null ) {
            customer.id( dto.getId() );
        }
        if ( dto.getCreateDate() != null ) {
            customer.createDate( new Timestamp( dto.getCreateDate().getTime() ) );
        }
        if ( dto.getUpdateDate() != null ) {
            customer.updateDate( new Timestamp( dto.getUpdateDate().getTime() ) );
        }
        if ( dto.getVersion() != null ) {
            customer.version( dto.getVersion() );
        }
        if ( dto.getName() != null ) {
            customer.name( dto.getName() );
        }
        if ( dto.getFamily() != null ) {
            customer.family( dto.getFamily() );
        }
        if ( dto.getNationalIdentifier() != null ) {
            customer.nationalIdentifier( dto.getNationalIdentifier() );
        }
        if ( dto.getBirthDate() != null ) {
            customer.birthDate( dto.getBirthDate() );
        }
        if ( dto.getPostalCode() != null ) {
            customer.postalCode( dto.getPostalCode() );
        }
        if ( dto.getAddress() != null ) {
            customer.address( dto.getAddress() );
        }
        if ( dto.getMobileNumber() != null ) {
            customer.mobileNumber( dto.getMobileNumber() );
        }
        if ( dto.getPersonalEmail() != null ) {
            customer.personalEmail( dto.getPersonalEmail() );
        }

        return customer.build();
    }

    @Override
    public List<CustomerDto> toDtoList(List<Customer> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<CustomerDto> list = new ArrayList<CustomerDto>( entityList.size() );
        for ( Customer customer : entityList ) {
            list.add( toDto( customer ) );
        }

        return list;
    }

    @Override
    public List<Customer> toEntityList(List<CustomerDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Customer> list = new ArrayList<Customer>( dtoList.size() );
        for ( CustomerDto customerDto : dtoList ) {
            list.add( toEntity( customerDto ) );
        }

        return list;
    }
}
