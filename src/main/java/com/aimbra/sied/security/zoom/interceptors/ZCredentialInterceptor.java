package com.aimbra.sied.security.zoom.interceptors;

import com.aimbra.sied.business.zoom.services.ZAppconfigurationService;
import com.aimbra.sied.business.zoom.services.impls.ZAppConfigurationServiceImpl;
import com.aimbra.sied.domain.zoom.dtos.ZAppConfigurationDto;
import com.aimbra.sied.security.sied.services.AuthenticationFacade;
import com.aimbra.sied.security.sied.services.IAuthenticationFacade;
import com.aimbra.sied.security.zoom.models.ZAppCredentials;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class ZCredentialInterceptor implements ClientHttpRequestInterceptor {

    @Getter @Setter
    private Map<String, String> headers = new HashMap<>();

    @Qualifier("ZAppConfigurationServiceImpl")
    @Autowired
    private ZAppconfigurationService configService;


    ZAppCredentials getCredentials() {
        String username = new AuthenticationFacade().getAuthentication().getName();
        ZAppConfigurationDto configurationDto = configService.findByUsername(username);
        return new ZAppCredentials(
                configurationDto.getApiKey(),
                configurationDto.getApiSecret(),
                configurationDto.getImChatHistoryToken(),
                configurationDto.getJwtToken()
        );
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        ZAppCredentials credentials = getCredentials();
        headers.put(HttpHeaders.AUTHORIZATION, credentials.getJwtToken());
        if (headers != null && !headers.isEmpty()) {
            headers.forEach((String key, String value) -> {
                httpRequest.getHeaders().set(key, value);
            });
        }
        return clientHttpRequestExecution.execute(httpRequest, bytes);
    }
}
