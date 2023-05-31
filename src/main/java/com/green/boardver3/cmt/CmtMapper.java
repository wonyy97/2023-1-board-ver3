package com.green.boardver3.cmt;

import com.green.boardver3.cmt.model.CmtInsDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CmtMapper {
    int insCmt(CmtInsDto dto);
}
