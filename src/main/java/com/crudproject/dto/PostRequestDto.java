package com.crudproject.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PostRequestDto {
    private Long id;
    private String title;
    private String content;
}


