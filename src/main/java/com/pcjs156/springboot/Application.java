package com.pcjs156.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 이 annotation으로 스프링 관련 설정이 일괄 처리됨
// 또한, 해당 annotation이 있는 위치부터 설정을 읽어가므로 프로젝트 루트에 있어야 함
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // 내장 WAS 실행
        SpringApplication.run(Application.class, args);
    }
}
