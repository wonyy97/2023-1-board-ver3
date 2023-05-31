package com.green.boardver3.board;

import com.green.boardver3.board.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private final BoardMapper mapper;

    @Autowired
    public BoardService(BoardMapper mapper) {
        this.mapper = mapper;
    }

    public int insBoard(BoardInsDto dto) {
        return mapper.insBoard(dto);
    }

    public List<BoardVo> selBoard(BoardSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRowLen());
        return mapper.selBoard(dto);
    }

    public int selLastBoard(int row) {
        double count = mapper.selLastBoard(row);
        return (int)Math.ceil(count/ row);
    }

    public BoardDetailVo selboardByid(BoardSelDto dto) {
        return mapper.selBoardById(dto);
    }

    public int delBoard(BoardDelDto dto) {
        return mapper.delBoard(dto);
    }

    public int updBoard(BoardUpdDto dto) {
        return mapper.updBoard(dto);
    }
}
