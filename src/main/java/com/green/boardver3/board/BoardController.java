package com.green.boardver3.board;

import com.green.boardver3.board.model.BoardDto;
import com.green.boardver3.board.model.BoardInsDto;
import com.green.boardver3.board.model.BoardVo;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService service;

    @Autowired
    public BoardController(BoardService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "글등록", description = "<h1>글 등록 가능해요</h1> <br> <h2> ୧(๑•̀ᗝ•́)૭ </h2>")
    public int postInsBoard(@RequestBody BoardInsDto dto) {
        return service.insBoard(dto);
    }

    @GetMapping
    public List<BoardVo> getSelBoard(@RequestParam @Min(value = 1, message = "1 이상") int page,
                                     @RequestParam (defaultValue = "30") int row) {
        BoardDto dto = new BoardDto();
        dto.setPage(page);
        dto.setRowLen(row);
        return service.selBoard(dto);
    }

}
