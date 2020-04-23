package com.aimbra.sied.security.zoom.models;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ZAppCredentials {

    @Value(value = "${zoom.api.url}")
    private String url;
    @Value(value = "${zoom.api.key}")
    private String apiKey;
    @Value(value = "${zoom.api.secret}")
    private String apiSecret;
    @Value(value = "${zoom.api.jwt}")
    private String imChatHistoryToken;
    @Value(value = "${zoom.api.imchathistorytoken}")
    private String jwtToken;


    public ZAppCredentials() {
        this.url = "https://api.zoom.us/v2";
//        this.apiKey = "b7Z3bjg5oII90b490Up8o3kC92bRIXdOO4aL";
//        this.apiSecret = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOm51bGwsImlzcyI6Ikl1M1lCbzVqVEEtbHNDQ3FnQmFOWUEiLCJleHAiOjE2MDI1NTc3MDAsImlhdCI6MTU4NjU3MDQ2NX0.0bzPSvlALKSC1_yUZsVJh2xMXsFNI-HU_cNDaOSyvu4";
//        this.imChatHistoryToken = "Iu3YBo5jTA-lsCCqgBaNYA";
//        this.jwtToken = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOm51bGwsImlzcyI6Ikl1M1lCbzVqVEEtbHNDQ3FnQmFOWUEiLCJleHAiOjE2MDc2NzgwNDAsImlhdCI6MTU4NjU3NjY2NH0.eaSqUh6fEk_ZXZwPa1xPB4wBQWK9KR18s3FzBgjpF9c";
    }

    public ZAppCredentials(String apiKey, String apiSecret, String imChatHistoryToken, String jwtToken) {
        this.url = "https://api.zoom.us/v2";
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.imChatHistoryToken = imChatHistoryToken;
        this.jwtToken = "Bearer " + jwtToken;
    }
}
