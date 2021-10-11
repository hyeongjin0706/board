package com.example.board.service;

import com.example.board.beans.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardServiceTest {
    @Autowired
    private BoardService boardService;

    /*    public void register(BoardVO board);
    public BoardVO get(Long bno);
    public boolean modify(BoardVO board);
    public boolean remove(Long bno);
    public List<BoardVO> getList();*/
    @Test
    public void testRegister(){
        BoardVO board = new BoardVO();
        board.setTitle("새로 작성하는 글5");
        board.setContent("새로 작성하는 내용5");
        board.setWriter("abcd1111");

        boardService.register(board);
        log.info(board.getBno() + "");
    }

    @Test
    public void testGet(){
        log.info(boardService.get(9L).toString());
    }

    @Test void testModify(){
        BoardVO board = new BoardVO();
        board.setBno(3L);
        board.setTitle("수정된 글 제목");
        board.setContent("수정된 글 내용");
        log.info("UPDATE : " + boardService.modify(board));
    }

    @Test
    public void testRemove(){
        log.info("DELETE : " + boardService.remove(22L));
    }

    @Test
    public void testGetList(){
        boardService.getList().forEach(board -> log.info(board.toString()));
    }
}
