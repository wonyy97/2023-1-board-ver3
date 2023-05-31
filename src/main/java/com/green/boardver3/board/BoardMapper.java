package com.green.boardver3.board;

import com.green.boardver3.board.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int insBoard(BoardEntity entity);
    List<BoardVo> selBoard(BoardSelDto dto);
    int selLastBoard(int row);
    BoardDetailVo selBoardById(BoardSelDto dto);
    int delBoard(BoardDelDto dto);
    int updBoard(BoardUpdDto dto);
}
