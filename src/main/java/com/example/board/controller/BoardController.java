package com.example.board.controller;

import com.example.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

//  프레젠테이션 계층의 구현
//  Task            URL                  Method      Parameter      From    URL 이동
//  전체 목록       /board/list          GET          없음           없음       없음
//  등록 처리       /board/register      POST         모든 항목      필요       이동
//  조회 처리       /board/read          GET          bno            필요      없음 
//  삭제 처리       /board/remove        POST         bno            필요      이동
//  수정 처리       /board/modify        POST         모든 항목       필요      이동
@Controller
@Slf4j
@RequestMapping("/board/*")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("list")
    public String list(Model model){
        log.info("~~~~~~~~~~~~~~~~~~~~~~~~");
        log.info("list");
        log.info("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        model.addAttribute("list", boardService.getList());
        return "board/list";
    }

    @GetMapping({"read", "modify"})
    public void read(@RequestParam("bno") Long bno, Model model, HttpServletRequest request){
        String reqURI = request.getRequestURI();
        log.info(reqURI);
    }

}
