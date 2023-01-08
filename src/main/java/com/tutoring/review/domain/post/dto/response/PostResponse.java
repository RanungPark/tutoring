package com.tutoring.review.domain.post.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PostResponse {
    private Long id;
    private Long userId;
    private String content;
    private Long like;
}


