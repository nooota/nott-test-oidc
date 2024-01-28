package com.example.pockeycloakapi.controller;

import com.example.pockeycloakapi.model.AuthBody;
import com.example.pockeycloakapi.model.TokenResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {

    private String tokenEndpoint = "http://localhost:8080/realms/nott-test-oidc/protocol/openid-connect/token";
    private String clientId = "nott";
    private String clientSecret = "jNzbvQ302jLgujPfvmfty9YadFbzQGOc";

    @Autowired
    private RestTemplate restTemplate;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/token")
    public TokenResponse getToken(@RequestBody AuthBody body) {
        log.info(body.getCode());
        log.info(body.getRedirectUrl());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("PRIVATE-TOKEN", "xyz");

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type","authorization_code");
        map.add("code",body.getCode());
        map.add("client_id", clientId);
        map.add("client_secret", clientSecret);
        map.add("redirect_uri", body.getRedirectUrl());

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);

        var response =  restTemplate.exchange(tokenEndpoint, HttpMethod.POST, entity, TokenResponse.class);

        return response.getBody();
    }
}
