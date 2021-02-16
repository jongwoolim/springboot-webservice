package org.zerock.board.service;


import org.zerock.board.dto.BoardDTO;
import org.zerock.board.dto.PageRequestDTO;
import org.zerock.board.dto.PageResultDTO;
import org.zerock.board.entity.Board;
import org.zerock.board.entity.Member;

public interface BoardService {

    Long register(BoardDTO dto);

    PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO);

    BoardDTO get(Long bno);

    void removeWithReplies(Long bno);

    void modify(BoardDTO boardDTO);


    default BoardDTO entityToDTO(Board board, Member member, Long replyCount){

        return BoardDTO.builder()
                .bno(board.getBno())
                .title(board.getTitle())
                .content(board.getContent())
                .regDate(board.getRegDate())
                .modDate(board.getModDate())
                .writerEmail(member.getEmail())
                .writerName(member.getName())
                .replyCount(replyCount.intValue())
                .build();

    }

    default Board dtoToEntity(BoardDTO boardDTO){

        Member member = Member.builder().email(boardDTO.getWriterEmail()).build();

        return Board.builder()
                    .title(boardDTO.getTitle())
                    .content(boardDTO.getContent())
                    .writer(member)
                    .build();
    }


}
