package org.zerock.board.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.board.entity.Board;
import org.zerock.board.entity.Member;
import org.zerock.board.repository.BoardRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

//@ExtendWith(SpringExtension.class)
@SpringBootTest
//@ActiveProfiles("test")
public class BoardRepositoryTest {


    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void testSearch1(){
        boardRepository.search1();
    }

    @Test
    public void testRead3(){
        final Object result = boardRepository.getBoardByBno(70L);

        Object[] arr = (Object[])result;
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void testWithReplyCount(){

        Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());

        final Page<Object[]> result = boardRepository.getBoardWithReplyCount(pageable);

        result.get().forEach(row -> {
            Object[] arr = (Object[])row;
            System.out.println(Arrays.toString(arr));
        });

    }

    @Test
    public void testGetBoardWithReply(){

        final List<Object[]> result = boardRepository.getBoardWithReply(98L);

        for(Object[] arr : result){
            System.out.println("---");
            System.out.println(Arrays.toString(arr));
        }
    }
    @Test
    public  void testReadWithWriter(){

        final Object result = boardRepository.getBoardWithWriter(70L);
        Object[] arr = (Object[])result;

        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testRead1(){

        final Optional<Board> result = boardRepository.findById(1l);

        System.out.println(result.get());
        System.out.println(result.get().getWriter());

    }

    private void createBoard() {
        Member member = Member.builder().email("user1" + "@aaa.com").password("1111").name("USER1").build();

        Board board = Board.builder().title("title1").content("content1").writer(member).build();
        boardRepository.save(board);
    }

    @Test
    public void insertBoard(){
        IntStream.rangeClosed(1, 100).forEach(i -> {

            Member member = Member.builder().email("user"+ i + "@aaa.com").build();

            Board board = Board.builder().title("title"+i).content("content"+i).writer(member).build();
            boardRepository.save(board);

        });
    }

}