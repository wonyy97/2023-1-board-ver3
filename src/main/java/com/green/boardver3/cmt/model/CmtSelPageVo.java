package com.green.boardver3.cmt.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CmtSelPageVo {
    private int iboardCmt;
    private int iboard;
    private int iuser;
    private String writer;
    private String writerMainpic;
    private String ctnt;
    private String createdAt;
}
