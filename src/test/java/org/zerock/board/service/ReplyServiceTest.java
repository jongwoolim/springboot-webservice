package org.zerock.board.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.board.dto.ReplyDTO;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ReplyServiceTest {

    @Autowired
    ReplyService replyService;


    @Test
    public void testGetList(){

        Long bno = 93L;

        final List<ReplyDTO> list = replyService.getList(bno);

        list.forEach(System.out::println);

    }


}