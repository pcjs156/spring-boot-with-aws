package com.pcjs156.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
public class PostsUpdateRequestDto {
    private String title;
    private String content;
}
