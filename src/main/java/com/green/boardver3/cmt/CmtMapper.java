package com.green.boardver3.cmt;

import com.green.boardver3.cmt.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CmtMapper {
    int insCmt(CmtEntity entity);
    List<CmtSelPageVo> selPageCmt(CmtSelPageDto dto);
    int updCmt(CmtEntity entity);
    int delCmt(CmtDelDto dto);
    int selLastCmt(int row);
}
