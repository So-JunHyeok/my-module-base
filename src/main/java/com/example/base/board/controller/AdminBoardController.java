package com.example.base.board.controller;

import com.example.base.board.domain.BoardCode;
import com.example.base.board.dto.BoardSearchParam;
import com.example.base.board.dto.BoardWriteParam;
import com.example.base.board.dto.CounseltationResult;
import com.example.base.board.service.BoardCodeService;
import com.example.base.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;
import java.util.Optional;

@Slf4j
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
    public String counseltation(BoardSearchParam boardParam, @PageableDefault(size = 10) Pageable pageable, Model model) {

        Page<CounseltationResult> page = boardService.conuseltationSearch(boardParam.getBoardCode(),boardParam.getType(), boardParam.getKeyword(), pageable);
        model.addAttribute("page", page);
        List<CounseltationResult> pinBoardList = boardService.pinBoardList(boardParam.getBoardCode());
        model.addAttribute("pinBoardList", pinBoardList);
        return "admin/board/counseltation";
    }

    @GetMapping("/counseltationDetail")
    public String counseltationDetail(BoardSearchParam boardParam, Model model) {
        boardParam.setBoardCode(1);
        CounseltationResult data = boardService.conuseltationData(boardParam.getBoardId(), boardParam.getBoardCode());
        model.addAttribute("data", data);
        model.addAttribute("boardParam",boardParam);
        log.info("DETAIL data = {}", data);
        log.info("prev = {}", data.getPrev());
        log.info("next = {}", data.getNext());

        return "admin/board/counseltationDetail";
    }

    @PostMapping("/pinned")
    public String togglePin(
            BoardSearchParam param,
            RedirectAttributes ra
    ) {
        boolean pinned = boardService.togglePin(param.getBoardId(), param.getBoardCode());

        ra.addFlashAttribute(
                "msg",
                pinned ? "고정되었습니다." : "고정 해제되었습니다."
        );

        return "redirect:/admin/counseltationDetail"
                + "?boardId=" + param.getBoardId()
                + "&currentPage=" + param.getCurrentPage()
                + (param.getType() != null ? "&type=" + param.getType() : "")
                + (param.getKeyword() != null ? "&keyword=" + param.getKeyword() : "");
    }

    @GetMapping("/construction")
    public String construction() {
        return "admin/board/construction";
    }

    @PostMapping
    public String constructionRegistation(BoardWriteParam boardWriteParam){
        return "";
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