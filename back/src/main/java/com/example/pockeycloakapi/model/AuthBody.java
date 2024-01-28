package com.example.pockeycloakapi.model;

import lombok.Data;

@Data
public class AuthBody {
    private String code;
    private String redirectUrl;
}
