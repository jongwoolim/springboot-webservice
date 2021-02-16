package org.zerock.board.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.dto.PageRequestDTO;
import org.zerock.board.dto.PageResultDTO;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Test
    public  void testModify(){

        BoardDTO boardDTO = BoardDTO.builder()
                .bno(2L)
                .title("update title")
                .content("update content")
                .build();

        boardService.modify(boardDTO);

    }

    @Transactional
    @Test
    public void testRemove(){

        Long bno = 2L;

        boardService.removeWithReplies(bno);
    }

    @Test
    public void testGet(){

        Long bno = 101L;

        final BoardDTO boardDTO = boardService.get(bno);

        System.out.println(boardDTO);
    }

    @Test
    public void testList(){

        PageRequestDTO pageRequestDTO = new PageRequestDTO();

        final PageResultDTO<BoardDTO, Object[]> result = boardService.getList(pageRequestDTO);

        for(BoardDTO boardDTO : result.getDtoList()){
            System.out.println(boardDTO);
        }

    }

    @Test
    @Transactional
    public void testRegister(){

        //Given
        final BoardDTO dto = BoardDTO.builder().title("Test....")
                .content("test....")
                .writerEmail("user55@aaa.com").build();

        final Long register = boardService.register(dto);

    }

}