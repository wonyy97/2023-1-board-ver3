package com.green.boardver3.cmt.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.List;

@Builder
@Getter
public class CmtRes {
    private int row;
    private int maxPage;
    private int page;
    private int isMore; //0 댓글 더 없음, 1 댓글 더 있음
    private List<CmtSelPageVo> list;
}
