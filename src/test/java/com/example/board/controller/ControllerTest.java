package com.example.board.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
public class ControllerTest {

//  가짜 MVC
//  마치 브라우저에서 URL 요청한 것처럼 환경을 만들어준다.
    private MockMvc mockMvc;

//    요청을 처리해주는 WebApplicationContext를 불러온다.
    @Autowired
    private WebApplicationContext webApplicationContext;

//    하위의 모든 테스트가 실행되기 전에 실행되도록한다.
    @BeforeEach
    public void setUp(){
//        가짜 MVC에 WebApplicationContext를 전달한 후 환경을 생성한다.
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testList() throws Exception{
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list")).andReturn().getModelAndView().getModelMap().toString());
    }
}
