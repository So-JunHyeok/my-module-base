package com.example.base.common;

import com.example.base.board.domain.BoardCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
@RequiredArgsConstructor
public class CommonAdvice {

    @ModelAttribute("count")
    public int count(){
        return 1;
    }
}
