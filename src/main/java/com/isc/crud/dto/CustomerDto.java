package com.isc.crud.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@Setter
@SuperBuilder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto extends BaseDto {
    private String name;
    private String family;
    private String nationalIdentifier;
    private String certificateSerial;
    private Integer birthDate;
    private BigDecimal postalCode;
    private String address;
    private String mobileNumber;
    private String personalEmail;
}
