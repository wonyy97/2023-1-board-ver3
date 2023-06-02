package com.green.boardver3.board.model;

import com.green.boardver3.cmt.model.CmtRes;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class BoardCmtDetailVo {
    private BoardDetailVo board;
    private CmtRes cmt;

}
