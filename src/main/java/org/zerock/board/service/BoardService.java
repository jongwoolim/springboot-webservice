package org.zerock.board.service;

import org.zerock.board.dto.BoardDTO;
import org.zerock.board.entity.Board;
import org.zerock.board.entity.Member;

public interface BoardService {

    Long register(BoardDTO dto);

    default Board dtoToEntity(BoardDTO boardDTO){

        Member member = Member.builder().email(boardDTO.getWriterEmail()).build();

        return Board.builder()
                    .title(boardDTO.getTitle())
                    .content(boardDTO.getContent())
                    .writer(member)
                    .build();
    }

}
