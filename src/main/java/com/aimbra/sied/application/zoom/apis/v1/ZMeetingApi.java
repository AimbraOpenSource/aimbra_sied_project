package com.aimbra.sied.application.zoom.apis.v1;

import com.aimbra.sied.business.zoom.services.ZMeetingService;
import com.aimbra.sied.domain.zoom.dtos.ZMeetingRequestDto;
import com.aimbra.sied.domain.zoom.dtos.ZMeetingResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@PreAuthorize("hasRole('PROFESSOR')")
@RestController
@RequestMapping(value = "/api/v1/zoom/meetings")
public class ZMeetingApi {

    @Qualifier("ZMeetingServiceImpl")
    @Autowired
    private ZMeetingService zMeetingService;

    @GetMapping
    public ResponseEntity<List<ZMeetingRequestDto>> findAll() {
        return ResponseEntity.ok(zMeetingService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ZMeetingRequestDto> findById(@PathVariable BigInteger id) {
        return ResponseEntity.ok(zMeetingService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ZMeetingResponseDto> create(@RequestBody ZMeetingRequestDto dto) {
        ZMeetingResponseDto metting = zMeetingService.create(dto);
        return ResponseEntity.ok(metting);
    }

}
