package com.aimbra.sied.domain.zoom.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ZUserResponseDto {

    @JsonProperty(value = "page_count")
    private Integer pageCount;

    @JsonProperty(value = "page_number")
    private Integer pageNumber;

    @JsonProperty(value = "page_size")
    private Integer pageSize;

    @JsonProperty(value = "total_records")
    private Integer totalRecords;

    private List<ZUserDto> users = new ArrayList<>();
}
