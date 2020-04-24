package com.aimbra.sied.business.zoom.services.impls;

import com.aimbra.sied.business.zoom.services.ZUserService;
import com.aimbra.sied.domain.zoom.dtos.ZUserDto;
import com.aimbra.sied.domain.zoom.dtos.responses.ZUserResponseDto;
import com.aimbra.sied.security.zoom.interceptors.ZCredentialInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ZUserServiceImpl implements ZUserService {

    @Autowired
    private ZCredentialInterceptor zCredentialInterceptor;

    @Value(value = "${zoom.api.url}")
    private String url;

    @Override
    public List<ZUserDto> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(List.of(zCredentialInterceptor));
        ZUserResponseDto userResponse = restTemplate.getForObject(url + "/users", ZUserResponseDto.class);
        assert userResponse != null;
        return userResponse.getUsers();
    }
}
