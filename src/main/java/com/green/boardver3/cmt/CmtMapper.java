package com.green.boardver3.cmt;

import com.green.boardver3.cmt.model.CmtEntity;
import com.green.boardver3.cmt.model.CmtInsDto;
import com.green.boardver3.cmt.model.CmtSelPageDto;
import com.green.boardver3.cmt.model.CmtSelPageVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CmtMapper {
    int insCmt(CmtEntity entity);
    List<CmtSelPageVo> selPageCmt(CmtSelPageDto dto);
}
