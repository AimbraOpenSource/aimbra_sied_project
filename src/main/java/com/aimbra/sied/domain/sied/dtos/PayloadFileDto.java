package com.aimbra.sied.domain.sied.dtos;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class PayloadFileDto<T> {
    private List<MultipartFile> file;
    private T t;
}
