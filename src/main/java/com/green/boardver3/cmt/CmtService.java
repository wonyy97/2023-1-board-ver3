package com.green.boardver3.cmt;

import com.green.boardver3.board.model.BoardEntity;
import com.green.boardver3.board.model.BoardInsDto;
import com.green.boardver3.cmt.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmtService {
    private final CmtMapper mapper;
//    private final int ROW =5;

    @Autowired
    public CmtService(CmtMapper mapper) {
        this.mapper = mapper;
    }

    public int insCmt(CmtEntity entity) {
        try{
            int result = mapper.insCmt(entity);
            if(result == 1) {
                return entity.getIboardCmt();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<CmtSelPageVo> selPageCmt(CmtSelPageDto dto) {
        int startIdx = ((dto.getPage() - 1) * dto.getRow());
        dto.setStartIdx(startIdx);
        return mapper.selPageCmt(dto);
    }

    public int delCmt(CmtDelDto dto) {
        return mapper.delCmt(dto);
    }

}
