package org.zerock.board.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.board.entity.Board;
import org.zerock.board.entity.Reply;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles("test")
class ReplyRepositoryTest {

    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void insertReply(){
        IntStream.rangeClosed(1, 100).forEach(i -> {

            long bno = (long)(Math.random() * 100) + 1;
            Board board = Board.builder().bno(bno).build();

            Reply reply = Reply.builder().text("Reply...."+i).board(board).replyer("guest").build();
            replyRepository.save(reply);
        });

    }
}