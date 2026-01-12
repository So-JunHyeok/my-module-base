package com.example.base.board.advice;

import com.example.base.board.domain.BoardCode;
import com.example.base.board.service.BoardCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@ControllerAdvice(basePackages = "com.example.base.board")
@RequiredArgsConstructor
public class BoardCommonAdvice {

    private final BoardCodeService boardCodeService;

    private static final String DEFAULT_BOARD_CODE = "notice";


    @ModelAttribute("boardCode")
    public BoardCode boardCode(
            @RequestParam(value = "boardCode", required = false) String boardCode
    ) {

        String resolvedCode =
                (boardCode == null)
                        ? DEFAULT_BOARD_CODE
                        : boardCode;

        return boardCodeService.findBoardDetail(resolvedCode).orElse(null);
    }
}


