package com.aimbra.sied.business.zoom.services.impls;

import com.aimbra.sied.business.zoom.services.ZMeetingService;
import com.aimbra.sied.business.zoom.services.ZUserService;
import com.aimbra.sied.domain.zoom.dtos.ZMeetingRequestDto;
import com.aimbra.sied.domain.zoom.dtos.ZMeetingResponseDto;
import com.aimbra.sied.domain.zoom.dtos.ZUserDto;
import com.aimbra.sied.domain.zoom.dtos.responses.ZMeetingResponseTemplateDto;
import com.aimbra.sied.security.zoom.interceptors.ZCredentialInterceptor;
import com.aimbra.sied.security.zoom.models.ZAppCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.util.List;

@Service
public class ZMeetingServiceImpl implements ZMeetingService {


    @Autowired
    private ZCredentialInterceptor zCredentialInterceptor;

    @Autowired
    private ZAppCredentials credentials;

    @Qualifier("ZUserServiceImpl")
    @Autowired
    private ZUserService zUserService;

    @Override
    public List<ZMeetingRequestDto> findAll() {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(List.of(zCredentialInterceptor));
        List<ZUserDto> zUsers = zUserService.findAll();
        String userId = zUsers.get(0).getId();
        ZMeetingResponseTemplateDto meetingResponse = restTemplate.getForObject(
                credentials.getUrl() + "/users/"+userId +"/meetings",
                ZMeetingResponseTemplateDto.class
        );
        assert meetingResponse != null;
        return meetingResponse.getMeetings();
    }

    @Override
    public ZMeetingRequestDto findById(BigInteger id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(List.of(zCredentialInterceptor));

        return restTemplate.getForObject(
                credentials.getUrl() + "/meetings/" + id,
                ZMeetingRequestDto.class
        );
    }

    @Override
    public ZMeetingResponseDto create(ZMeetingRequestDto dto) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(List.of(zCredentialInterceptor));
        List<ZUserDto> zUsers = zUserService.findAll();
        String userId = zUsers.get(0).getId();
        ZMeetingResponseDto meetingResponse = restTemplate.postForObject(
                credentials.getUrl() + "/users/"+userId +"/meetings",
                dto,
                ZMeetingResponseDto.class
        );
        return meetingResponse;
    }
}
