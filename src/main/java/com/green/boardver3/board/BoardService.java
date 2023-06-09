package com.green.boardver3.board;

import com.green.boardver3.board.model.*;
import com.green.boardver3.cmt.CmtService;
import com.green.boardver3.cmt.model.CmtDelDto;
import com.green.boardver3.cmt.model.CmtRes;
import com.green.boardver3.cmt.model.CmtSelPageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {
    private final BoardMapper mapper;
    private final CmtService cmtService;
    private final int ROW = 5;


    @Autowired
    public BoardService(BoardMapper mapper, CmtService cmtService) {
        this.mapper = mapper;
        this.cmtService = cmtService;
    }

    public int insBoard(BoardInsDto dto) {
        BoardEntity entity = new BoardEntity();
        entity.setTitle(dto.getTitle());
        entity.setCtnt(dto.getCtnt());
        entity.setIuser(dto.getIuser());
        int result = mapper.insBoard(entity);
        if (result == 1) {
            return entity.getIboard();
        }
        return result;
    }

    public List<BoardVo> selBoard(BoardSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRowLen());
        return mapper.selBoard(dto);
    }

    public int selLastBoard(int row) {
        double count = mapper.selLastBoard(row);
        return (int)Math.ceil(count / row);
    }

    public BoardCmtDetailVo selboardByid(BoardSelDto dto) {
        BoardDetailVo vo = mapper.selBoardById(dto); //원래 게시글 디테일

        CmtSelPageDto cmtDto = new CmtSelPageDto();
        cmtDto.setPage(dto.getPage());
        cmtDto.setIboard(dto.getIboard());
        cmtDto.setRow(ROW);

        CmtRes cmtRes = cmtService.selPageCmt(cmtDto);
        
        return BoardCmtDetailVo.builder()
                .board(vo)
                .cmt(cmtRes)
                .build();

    }

    @Transactional(rollbackFor = Exception.class)
    public int delBoard(BoardDelDto dto) throws Exception {
        // 그 글에 달려있는 댓글을 전부 삭제해야 함.

        CmtDelDto delDto = new CmtDelDto();
        delDto.setIboard(dto.getIboard());
        cmtService.delCmt(delDto);

        int result = 0;
        result = mapper.delBoard(dto);
        if (result == 0) {
            throw new Exception("삭제 권한 없음");
        }

        return result;


    }

    public int updBoard(BoardUpdDto dto) {
        return mapper.updBoard(dto);
    }
}
