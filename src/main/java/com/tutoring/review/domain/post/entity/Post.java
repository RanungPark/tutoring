package com.tutoring.review.domain.post.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

// @Getter get을 하지 않고 접근자를 생성할수 있다
// @Builder 빌더를 자동으로 작성해준다 클래스에 작성하면 모든 필드에 대한 빌더를 만들어준다
// 특정 변수만 build하기를 원하면 생성자를 작성하고 그위에 어노테이션을 작성한다
// @AllArgsConstructor RequiredArgsConstructor과 달리 전체 변수를 생선하는 생성자를 만들어준다
// (모든 필드 값을 파라미터로 받는 생성자를 만들어준다)

@Getter
@Builder
@AllArgsConstructor
public class Post {

    private Long id;
    private Long userId;
    private String content;
    private Long like;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}