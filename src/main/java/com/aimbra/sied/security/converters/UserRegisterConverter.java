package com.aimbra.sied.security.converters;

import com.aimbra.sied.business.converters.Converter;
import com.aimbra.sied.security.dtos.UserRegisterDto;
import com.aimbra.sied.security.entities.UserEntity;
import org.springframework.stereotype.Component;

//@Component
//public class UserRegisterConverter extends Converter<UserRegisterDto, UserEntity> {
//
////    public UserRegisterConverter() {
////        super(fromDto -> {
////            UserEntity entity = new UserEntity();
////            entity.setUsername(fromDto.getUsername());
////            entity.setPassoword(fromDto.getPassword());
////            entity.setRole(fromDto.getRole());
////            return entity;
////        }, fromEntity -> {
////            UserRegisterDto dto = new UserRegisterDto();
////            dto.setUsername(dto.getUsername());
////            dto.setPassword(dto.getPassword());
////            dto.setRole(dto.getRole());
////            return dto;
////        });
//    }
//}
