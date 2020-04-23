package com.aimbra.sied.security.zoom.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.RequestScope;

import javax.servlet.http.HttpServletRequest;

@Component
public class ZRestTemplateConfig {
    @Bean
    @RequestScope
    public RestTemplate keycloakRestTemplate(HttpServletRequest httpServletRequest) {
        final String authHeader = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
        final RestTemplate restTemplate = new RestTemplate();
        if (authHeader != null && !authHeader.isEmpty()) {
            restTemplate.getInterceptors().add((outReq, bytes, clientHttpReqExec) -> {
                outReq.getHeaders().set(HttpHeaders.AUTHORIZATION, authHeader);
                return clientHttpReqExec.execute(outReq, bytes);
            });
        }
        return restTemplate;
    }
}
