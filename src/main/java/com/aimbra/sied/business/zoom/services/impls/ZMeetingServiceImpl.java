package com.aimbra.sied.business.zoom.services.impls;

import com.aimbra.sied.business.zoom.services.ZMeetingService;
import com.aimbra.sied.domain.zoom.dtos.ZMeetingDto;
import com.aimbra.sied.domain.zoom.dtos.responses.ZMeetingResponseDto;
import com.aimbra.sied.security.zoom.interceptors.ZCredentialInterceptor;
import com.aimbra.sied.security.zoom.models.ZAppCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ZMeetingServiceImpl implements ZMeetingService {


    @Autowired
    private ZCredentialInterceptor zCredentialInterceptor;

    private ZAppCredentials credentials = new ZAppCredentials();

    @Override
    public List<ZMeetingDto> findAll(String username) {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(List.of(zCredentialInterceptor));
        String userId = "qHTncD-QRQSTuYas11qZdQ";
        ZMeetingResponseDto meetingResponse = restTemplate.getForObject(
                credentials.getUrl() + "/users/"+userId +"/meetings",
                ZMeetingResponseDto.class
        );
        assert meetingResponse != null;
        return meetingResponse.getMeetings();
    }

    @Override
    public ZMeetingDto findById(Integer id, String username) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(List.of(zCredentialInterceptor));

        return restTemplate.getForObject(
                credentials.getUrl() + "/meetings/" + id,
                ZMeetingDto.class
        );
    }
}
