package org.zerock.board.repository.search;

import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.zerock.board.entity.Board;


public interface SearchBoardRepository {

    Board search1();
}
