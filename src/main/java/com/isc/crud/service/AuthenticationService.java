package com.isc.crud.service;

import com.isc.crud.dto.AuthenticationRequestDto;
import com.isc.crud.dto.AuthenticationResponseDto;

public interface AuthenticationService {
    AuthenticationResponseDto authenticate(AuthenticationRequestDto requestDto);
}
