package com.pcjs156.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 컨트롤러가 json으로 반환하도록 설정
@RestController()
public class HelloController {
    // 인자로 전달된 경로의 get method만 받음
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
