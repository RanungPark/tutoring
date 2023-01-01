package com.tutoring.review.domain.post.dto;


import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class PostRequest {
    private Long userId;
    private String content;
}
