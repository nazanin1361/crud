package com.isc.crud.entity;

import com.isc.crud.entity.constant.CustomerConstant;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Entity
@Table(name = CustomerConstant.TABLE_NAME)

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BaseEntity {
    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String family;

    @Column(name = CustomerConstant.NATIONAL_IDENTIFIER, length = 16, nullable = false)
    private String nationalIdentifier;

    @Column(length = 8)
    private Integer birthDate;

    @Column(length = 10)
    private BigDecimal postalCode;

    @Column
    private String address;

    @Column(length = 1)
    private Integer gender;

    @Column(name = CustomerConstant.MOBILE_NUMBER, length = 11, nullable = false)
    private String mobileNumber;

    @Column(length = 100)
    private String personalEmail;
}
