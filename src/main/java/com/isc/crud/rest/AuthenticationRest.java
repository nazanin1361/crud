package com.isc.crud.rest;

import com.isc.crud.dto.AuthenticationRequestDto;
import com.isc.crud.dto.AuthenticationResponseDto;
import com.isc.crud.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/crud/auth")
@RequiredArgsConstructor
public class AuthenticationRest {
    private final AuthenticationService authenticationService;

    @PostMapping("/authenticate-customer")
    public ResponseEntity<AuthenticationResponseDto> authenticate(@RequestBody AuthenticationRequestDto authenticationRequestDto) {
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequestDto));

    }

}
