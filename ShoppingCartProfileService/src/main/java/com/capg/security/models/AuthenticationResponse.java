package com.capg.security.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
//@NoArgsConstructor
public class AuthenticationResponse {

    private final String jwt;

}
