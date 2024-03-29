package com.tutoring.review.domain.post.service;

import com.tutoring.review.domain.post.dao.PostMapper;
import com.tutoring.review.domain.post.dto.request.PostRequest;
import com.tutoring.review.domain.post.dto.response.PostResponse;
import com.tutoring.review.domain.post.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

// @Service 해당 클래스가 Service클래스임을 명시한다
// @Transactional 클래스나 메서드에 붙을경우 해당 범위 내 메서드가 트랜젝션이 되도록 보장해준다
// 트렌젝션이란 더 이상 쪼개질 수 없는 최소 연산 단위로 데이터 베이스 관리 시스템에서 상호작용의 단위를 의미한다

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostMapper postMapper;

    @Transactional(readOnly = true)
    public List<PostResponse> selectPosts() {
        List<Post> posts = postMapper.selectPosts();
        List<PostResponse> postsResponse = new ArrayList<>();

        for (Post post : posts) {
            PostResponse postResponse = PostResponse.builder()
                    .id(post.getId())
                    .userId(post.getUserId())
                    .content(post.getContent())
                    .like(post.getLike())
                    .build();

            postsResponse.add(postResponse);
        }
        return postsResponse;
    }

    /*
    게시물을 새로 만드는 컨트롤러
     */
    @Transactional
    public PostResponse insertPost(PostRequest postRequest) {
        Post post = postRequest.toEntity();
        postMapper.insertPost(post);

        System.out.println(postRequest.getData().toString());

        PostResponse postResponse1 = new PostResponse(
                1L,
                1L,
                "안녕하세요",
                0L
        );




        PostResponse postResponse = PostResponse.builder()
                .id(1L)
                .userId(1L)
                .content("안녕하세요")
                .like(0L)
                .build();




        return postResponse;
    }
}
