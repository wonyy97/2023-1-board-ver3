package com.green.boardver3.board.model;

import lombok.Data;

@Data
public class BoardDetailVo {
    private int iboard;
    private String title;
    private String ctnt;
    private String writer;
    private String createdAt;
    private String writerMainPic;
}
