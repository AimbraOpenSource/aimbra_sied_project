package com.aimbra.sied.application.zoom.apis.v1;

import com.aimbra.sied.domain.zoom.dtos.ZUserDto;
import com.aimbra.sied.domain.zoom.dtos.responses.ZUserResponseDto;
import com.aimbra.sied.security.zoom.interceptors.ZCredentialInterceptor;
import com.aimbra.sied.security.zoom.models.ZAppCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/zoom/users")
public class ZUserApi {

    @Value(value = "${zoom.api.url}")
    private String url;

    @Autowired
    private ZCredentialInterceptor zCredentialInterceptor;

    @GetMapping
    public ResponseEntity<List<ZUserDto>> findAll() {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(List.of(zCredentialInterceptor));
        ZUserResponseDto userResponse = restTemplate.getForObject(url + "/users", ZUserResponseDto.class);
        assert userResponse != null;
        List<ZUserDto> users = userResponse.getUsers();
        return ResponseEntity.ok(users);
    }

}
