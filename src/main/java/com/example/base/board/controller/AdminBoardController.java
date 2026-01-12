package com.example.base.board.controller;

import com.example.base.board.domain.BoardCode;
import com.example.base.board.dto.BoardResponse;
import com.example.base.board.dto.BoardSearchParam;
import com.example.base.board.dto.BoardWriteParam;
import com.example.base.board.service.BoardCodeService;
import com.example.base.board.service.BoardService;
import com.example.base.consultation.dto.ConsultationResult;
import com.example.base.security.auth.principal.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/board")
public class AdminBoardController {

    private final BoardService boardService;
    private final BoardCodeService boardCodeService;


    @GetMapping("/{boardCode}/list")
    public String boardList(@PathVariable String boardCode, @PageableDefault(size = 10) Pageable pageable, BoardSearchParam param, Model model) {
        BoardCode code = boardCodeService.findBoardDetail(boardCode)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시판 코드"));

        Page<BoardResponse> page = boardService.boardList(boardCode, pageable);
        List<BoardResponse> pinBoardList = boardService.pinBoardList(boardCode);

        model.addAttribute("page", page);
        model.addAttribute("pinBoardList", pinBoardList);

        return resolveListView(code.getBoardType());
    }

    @PostMapping("/{boardCode}/write")
    public String constructionRegistation(@PathVariable String boardCode, BoardWriteParam boardWriteParam, CustomUserDetails loginUser) throws Exception{
        String path = "admin/board/" + boardCode + "/list";
        boardWriteParam.setBoardCode(boardCode);
        boardService.write(boardWriteParam, loginUser);
        return "redirect:/" + path;
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

        return "redirect:/admin/counseltation/detail"
                + "?boardId=" + param.getBoardId()
                + "&currentPage=" + param.getCurrentPage()
                + (param.getType() != null ? "&type=" + param.getType() : "")
                + (param.getKeyword() != null ? "&keyword=" + param.getKeyword() : "");
    }


    private String resolveListView(String boardType){

        String path = "admin/board/";

        switch (boardType){
            case "GALLERY" : return path + "list_gallery";
            default: return path + "list_text";
        }
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