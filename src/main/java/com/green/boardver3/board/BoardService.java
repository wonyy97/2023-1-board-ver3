package com.green.boardver3.board;

import com.green.boardver3.board.model.BoardSelDto;
import com.green.boardver3.board.model.BoardInsDto;
import com.green.boardver3.board.model.BoardVo;
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

    public List<BoardVo> selBoard(BoardSelDto dto){
        dto.setStartIdx((dto.getPage()-1) * dto.getRowLen());
        return mapper.selBoard(dto);
    }
}
