package com.aimbra.sied.domain.zoom.dtos;

import com.aimbra.sied.security.sied.dtos.UserDto;
import com.aimbra.sied.security.sied.entities.UserEntity;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ZAppConfigurationDto {

    private Integer id;
    private String apiKey;
    private String apiSecret;
    private String imChatHistoryToken;
    private String jwtToken;
    private LocalDateTime expiredAt;
    private UserDto user;
}
