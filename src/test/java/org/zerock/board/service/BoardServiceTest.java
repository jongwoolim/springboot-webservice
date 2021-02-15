package org.zerock.board.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.board.dto.BoardDTO;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BoardServiceTest {

    @Autowired
    private BoardService boardService;

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