package com.green.boardver3.cmt;

import com.green.boardver3.board.model.BoardSelDto;
import com.green.boardver3.cmt.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class CmtController {
    private final CmtService service;

    @Autowired
    public CmtController(CmtService service) {
        this.service = service;
    }

    @PostMapping("/{iboard}/cmt")
    public int postCmt(@PathVariable int iboard
            , @RequestBody CmtInsDto dto) { //CmtInsDto dto swagger 때문에 사용된다.
        CmtEntity entity = new CmtEntity();
        entity.setIboard(iboard);
        entity.setIuser(dto.getIuser());
        entity.setCtnt(dto.getCtnt());
        return service.insCmt(entity);
    }

    @GetMapping("/{iboard}/cmt")
    public CmtRes selPageCmt(@PathVariable int iboard
                                        , @RequestParam int page
                                        , @RequestParam(defaultValue = "5") int row) {
        CmtSelPageDto dto = new CmtSelPageDto();
        dto.setPage(page);
        dto.setRow(row);
        dto.setIboard(iboard);
        return service.selPageCmt(dto);
    }

    @PutMapping("/cmt/{iboardCmt}")
    public int updCmt(@PathVariable int iboardCmt
            ,@RequestBody CmtUpdDto dto) {
        CmtEntity entity = new CmtEntity();
        entity.setIboardCmt(iboardCmt);     //잘보기
        entity.setIuser(dto.getIuser());
        entity.setCtnt(dto.getCtnt());
        return service.updCmt(entity);
    }

    @DeleteMapping("/cmt/{iboardCmt}")
    public int delCmt(@RequestParam int iuser,
                      @PathVariable int iboardCmt) {
        CmtDelDto dto = new CmtDelDto();
        dto.setIuser(iuser);
        dto.setIboardCmt(iboardCmt);
        return service.delCmt(dto);
    }

}
