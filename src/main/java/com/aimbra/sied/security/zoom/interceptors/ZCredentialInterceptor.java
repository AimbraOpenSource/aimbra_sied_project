package com.aimbra.sied.security.zoom.interceptors;

import com.aimbra.sied.security.zoom.models.ZAppCredentials;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ZCredentialInterceptor implements ClientHttpRequestInterceptor {

    @Getter @Setter
    private Map<String, String> headers = new HashMap<>();

    public ZCredentialInterceptor() {
    }

    public ZCredentialInterceptor(Map<String, String> headers) {
        this.headers = headers;
    }

    public ZCredentialInterceptor(String key, String value) {
        this.headers.put(key, value);
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        ZAppCredentials credentials = new ZAppCredentials();
        headers.put(HttpHeaders.AUTHORIZATION, credentials.getJwtToken());
        if (headers != null && !headers.isEmpty()) {
            headers.forEach((String key, String value) -> {
                httpRequest.getHeaders().set(key, value);
            });
        }
        return clientHttpRequestExecution.execute(httpRequest, bytes);
    }
}
