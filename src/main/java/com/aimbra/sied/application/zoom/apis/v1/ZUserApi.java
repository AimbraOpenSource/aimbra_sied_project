package com.aimbra.sied.application.zoom.apis.v1;

import com.aimbra.sied.business.zoom.services.ZUserService;
import com.aimbra.sied.domain.zoom.dtos.ZUserDto;
import com.aimbra.sied.domain.zoom.dtos.responses.ZUserResponseDto;
import com.aimbra.sied.security.zoom.interceptors.ZCredentialInterceptor;
import com.aimbra.sied.security.zoom.models.ZAppCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@PreAuthorize("hasRole('PROFESSOR')")
@RestController
@RequestMapping(value = "/api/v1/zoom/users")
public class ZUserApi {

    @Qualifier("ZUserServiceImpl")
    @Autowired
    private ZUserService userService;

    @GetMapping
    public ResponseEntity<List<ZUserDto>> findAll() {
        List<ZUserDto> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

}
