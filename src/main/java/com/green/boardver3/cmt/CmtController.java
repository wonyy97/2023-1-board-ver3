package com.green.boardver3.cmt;

import com.green.boardver3.board.model.BoardSelDto;
import com.green.boardver3.cmt.model.CmtEntity;
import com.green.boardver3.cmt.model.CmtInsDto;
import com.green.boardver3.cmt.model.CmtSelPageDto;
import com.green.boardver3.cmt.model.CmtSelPageVo;
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

    @PostMapping("/cmt")
    public int postCmt(@RequestBody CmtInsDto dto) { //CmtInsDto dto swagger 때문에 사용된다.
        return service.insCmt(dto);
    }

    @GetMapping("/{iboard}/cmt")
    public List<CmtSelPageVo> selPageCmt(@PathVariable int iboard ,@RequestParam(defaultValue = "1") int page
                                            ,@RequestParam(defaultValue = "5") int row) {
        CmtSelPageDto dto = new CmtSelPageDto();
        dto.setPage(page);
        dto.setRow(row);
        dto.setIboard(iboard);
        return service.selPageCmt(dto);
    }
}
