package com.green.boardver3.board.model;

import lombok.Builder;
import lombok.Data;

@Data
public class BoardSelDto {
    private int startIdx;
    private int page;
    private int rowLen;

}
