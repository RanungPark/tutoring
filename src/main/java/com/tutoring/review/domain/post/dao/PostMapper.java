package com.tutoring.review.domain.post.dao;

import com.tutoring.review.domain.post.dto.PostRequest;
import com.tutoring.review.domain.post.entity.Post;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

// @Mapper는 보통 인터페이스를 매퍼로 등록하기 위해 사용하는데
// MyBatis의 mappers를 위한 maker interface로 사용한다
// @Repository는 해당 인터페이스가 저장소라는 것을 명시한다

@Mapper
@Repository
public interface PostMapper {
    List<Post> selectPosts();

    void insertPosts(PostRequest postRequest);
}
