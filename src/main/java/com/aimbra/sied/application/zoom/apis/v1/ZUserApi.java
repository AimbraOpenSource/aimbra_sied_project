package com.aimbra.sied.application.zoom.apis.v1;

import com.aimbra.sied.domain.zoom.dtos.ZUserDto;
import com.aimbra.sied.domain.zoom.dtos.responses.ZUserResponseDto;
import com.aimbra.sied.security.zoom.interceptors.ZCredentialInterceptor;
import com.aimbra.sied.security.zoom.models.ZAppCredentials;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/zoom/users")
public class ZUserApi {

    @GetMapping
    public ResponseEntity<List<ZUserDto>> findAll() {
        ZAppCredentials credentials = new ZAppCredentials();
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(List.of(new ZCredentialInterceptor()));
        ZUserResponseDto userResponse = restTemplate.getForObject(credentials.getUrl() + "/users", ZUserResponseDto.class);
        assert userResponse != null;
        List<ZUserDto> users = userResponse.getUsers();
        return ResponseEntity.ok(users);
    }

}
