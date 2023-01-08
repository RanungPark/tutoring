package com.tutoring.review.domain.post.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tutoring.review.domain.post.dto.request.PostRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("게시물 등록 성공 테스트")
    public void postTest() throws Exception {
        PostRequest postRequest = PostRequest.builder().userId(1L).content("테스트입니다.").build();
        String content = objectMapper.writeValueAsString(postRequest);

        this.mockMvc.perform(post("/posts")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("게시물 등록 실패 테스트 - 콘텐츠를 입력하지 않았을 때")
    public void postWhenContentIsNullTest() throws Exception {
        PostRequest postRequest = PostRequest.builder().userId(1L).content(null).build();
        String content = objectMapper.writeValueAsString(postRequest);

        this.mockMvc.perform(post("/posts")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}