package com.aimbra.sied.application.zoom.apis.v1;

import com.aimbra.sied.business.sied.services.UserService;
import com.aimbra.sied.business.zoom.services.ZAppconfigurationService;
import com.aimbra.sied.domain.zoom.dtos.ZAppConfigurationDto;
import com.aimbra.sied.security.sied.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/api/v1/zoom/configurations")
public class ZAppConfigurationApi {

    @Qualifier("ZAppConfigurationServiceImpl")
    @Autowired
    private ZAppconfigurationService service;

    @Qualifier("userServiceImpl")
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<ZAppConfigurationDto> findByUsername(@AuthenticationPrincipal UserDetails userDetails) {
        ZAppConfigurationDto byUsername = service.findByUsername(userDetails.getUsername());
        return ResponseEntity.ok(byUsername);
    }

    @PostMapping
    public ResponseEntity<ZAppConfigurationDto> save(@RequestBody ZAppConfigurationDto dto, @AuthenticationPrincipal UserDetails userDetails) {
        UserDto user = userService.findByUsername(userDetails.getUsername());
        dto.setUser(user);
        dto.setExpiredAt(LocalDateTime.now().plusDays(7).toString());
        return ResponseEntity.ok(service.save(dto));
    }

}
