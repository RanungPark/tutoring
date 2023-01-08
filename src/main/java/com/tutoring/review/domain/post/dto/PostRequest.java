package com.tutoring.review.domain.post.dto;

import com.tutoring.review.domain.post.entity.Post;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@Getter
public class PostRequest {
    @NotNull(message = "유저 아이디는 Null이 될 수 없습니다")
    private Long userId;

    @NotBlank(message = "콘텐츠를 입력해주세요")
    @Size(min = 1, max = 1000, message = "콘텐츠는 1000자를 넘길 수 없습니다")
    private String content;

    public Post toEntity() {

        return Post.builder()
                .userId(this.userId)
                .content(this.content)
                .build();
    }
}
