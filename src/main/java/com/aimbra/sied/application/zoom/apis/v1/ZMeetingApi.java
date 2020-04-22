package com.aimbra.sied.application.zoom.apis.v1;

import com.aimbra.sied.business.zoom.services.ZMeetingService;
import com.aimbra.sied.domain.zoom.dtos.ZMeetingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/zoom/meetings")
public class ZMeetingApi {

    @Qualifier("ZMeetingServiceImpl")
    @Autowired
    private ZMeetingService zMeetingService;

    @GetMapping
    public ResponseEntity<List<ZMeetingDto>> findAll() {
        return ResponseEntity.ok(zMeetingService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ZMeetingDto> findAll(@PathVariable Integer id) {
        return ResponseEntity.ok(zMeetingService.findById(id));
    }


}
