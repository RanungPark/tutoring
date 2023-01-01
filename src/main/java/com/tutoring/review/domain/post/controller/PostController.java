package com.tutoring.review.domain.post.controller;

import com.tutoring.review.domain.post.dto.PostRequest;
import com.tutoring.review.domain.post.dto.PostResponse;
import com.tutoring.review.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
// @Controller 해당 어노테이션이 적용된 클래스는 Controller임을 나타내고, bean으로 등록되면 해당 클래스가
// Controller로 사용됨을 Spring Framework에 알린다
// @RequestMapping 어노테이션으로, 요청 url값과 Http Method를 정의해주는 곳
// @RequiredArgsConstructor 롬복의 어노테이션으로 생성자와 setter, field를 자동으로 만들어 준다
// final혹은 @NotNull이 붙은 필드의 생성자를 자동으로 만들어준다
// @GetMapping HTTP GET요청을 처리하는 메서드를 맵핑하는 어노테이션이다
// @RequestBody는 리턴되는 값이 Http RequestBody에 직접 쓰여진다

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity<List<PostResponse>> getPosts() {
        List<PostResponse> postsResponse = postService.selectPosts();
        return ResponseEntity.ok().body(postsResponse);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> insertPosts(@RequestBody PostRequest postRequest) {
        postService.insertPosts(postRequest);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
