package com.tutoring.review.domain.post.dto.request;

import com.tutoring.review.domain.post.entity.Post;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@Getter
public class PostRequest {
    private Long userId;

    @NotBlank(message = "콘텐츠를 입력해주세요")
    @Size(max = 1000, message = "콘텐츠는 1000자를 넘길 수 없습니다.")
    private String content;

    public Post toEntity() {

        return Post.builder()
                .userId(this.userId)
                .content(this.content)
                .build();
    }
}
