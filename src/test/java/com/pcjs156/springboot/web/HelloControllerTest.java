package com.pcjs156.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// 테스트를 진행할 때 JUnit 내장 runner 외에 다른 runner를 사용하고자 할 때 사용
// (여기서는 SpringRunner를 사용함)
@RunWith(SpringRunner.class)
// Web(Spring MVC) test에 집중할 수 있게 해주는 annotation으로,
// @Controller, @ControllerAdvice를 사용할 수 있음
// 단, @Service, @Component, @Repository 등은 사용할 수 없음
// 여기서는 Controller만 사용하므로 썼음
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {
    // 스프링이 관리하는 bean을 주입 받음
    @Autowired
    // 웹 API를 테스트할 때 사용하며, 스프링 MVC 테스트의 시작점임
    // 해당 클래스를 통해 HTTP Get, Post 등의 API 테스트 수행 가능
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }
}
