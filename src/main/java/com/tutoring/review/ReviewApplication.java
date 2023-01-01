package com.tutoring.review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication은 세가지 기능을 활성화 할 수 있다
// @EnableAutoConfiguration은 SpingBoot의 자동 구성 메커니즘 활성화
// @EnableAutoConfiguration은 사전에 정의한 라이브러리가 특정 조건이 만족될 경우 Bean으로 등록해 주는 어노테이션이다
// 1) 특정 Bean이 사전에 생성 되어 있지 않을 경우에 조건 만족 @OnBeanCondition
// 2) 특정 Bean이 이미 생성되어일을 경우에 조건이 만족 @ConditionalOnBean
// 3) Classpath에 특정 class가 존재할 경우에 조건이 만족 @ConditionalOnClass
// @ComponentScan은 @Component 애플리케이션이 있는 패키지에서 검사를 활성화
// 이때 패키지는 @Service,@Repsitory,@Controller가 있다
// @Configuration은 컨텍스트에 추가 빈을 등록하거나 추가 구성 클래스를 가져올 수 있다

@SpringBootApplication
public class ReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewApplication.class, args);
	}

}

