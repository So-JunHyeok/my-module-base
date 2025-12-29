package com.example.base.board.controller;

import com.example.base.board.domain.BoardCode;
import com.example.base.board.dto.BoardSearchParam;
import com.example.base.board.dto.CounseltationResult;
import com.example.base.board.service.BoardCodeService;
import com.example.base.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminBoardController {

    private final BoardService boardService;
    private final BoardCodeService boardCodeService;

    @GetMapping("/board")
    public String board() {
        return "admin/board";
    }

    @GetMapping("/counseltation")
    public String counseltation(BoardSearchParam param, @PageableDefault(size = 10) Pageable pageable, Model model) {

        Page<CounseltationResult> page = boardService.conuseltationSearch("1",param.getType(), param.getKeyword(), pageable);
        model.addAttribute("page", page);

        return "admin/board/counseltation";
    }

    @GetMapping("/counseltationDetail")
    public String counseltationDetail() {
        return "admin/board/counseltationDetail";
    }
}
/*
Page<BoardResponse> page
│
├─ content : List<BoardResponse>   ← ★ 실제 데이터
│
├─ number : int                    ← 현재 페이지 번호 (0부터)
├─ size : int                      ← 페이지당 개수
│
├─ totalElements : long            ← 전체 데이터 수
├─ totalPages : int                ← 전체 페이지 수
│
├─ hasNext : boolean
├─ hasPrevious : boolean
 */