package org.zerock.board.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.board.entity.Board;
import org.zerock.board.entity.Member;
import org.zerock.board.repository.BoardRepository;

import java.util.stream.IntStream;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles("test")
public class BoardRepositoryTest {


    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void insertBoard(){
        IntStream.rangeClosed(1, 100).forEach(i -> {

            Member member = Member.builder().email("user"+ i + "@aaa.com").build();

            Board board = Board.builder().title("title"+i).content("content"+i).writer(member).build();
            boardRepository.save(board);

        });
    }
}