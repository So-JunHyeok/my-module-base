package com.example.base.board.service;

import com.example.base.board.domain.Board;
import com.example.base.board.dto.CounseltationResult;
import com.example.base.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public Page<CounseltationResult> conuseltationList(String boardCode, Pageable pageable){
        return boardRepository.findByBoardCodeOrderByCreatedAtDesc(boardCode, pageable)
                .map(CounseltationResult :: from);
    }

    public Page<CounseltationResult> conuseltationSearch(String boardCode, String searchType, String keyword, Pageable pageable){
        if (keyword == null || keyword.isBlank()) {
            return boardRepository.findByBoardCodeOrderByCreatedAtDesc(boardCode, pageable)
                    .map(CounseltationResult :: from);
        }

        switch (searchType) {
            case "writer" :
                return boardRepository.findByBoardCodeAndWriterContainingOrderByCreatedAtDesc(boardCode, keyword, pageable)
                        .map(CounseltationResult :: from);
            case "content" :
                return boardRepository.findByBoardCodeAndContentContainingOrderByCreatedAtDesc(boardCode, keyword, pageable)
                        .map(CounseltationResult :: from);
            case "email" :
                return boardRepository.findByBoardCodeAndEmailContainingOrderByCreatedAtDesc(boardCode, keyword, pageable)
                        .map(CounseltationResult :: from);
            case "tel" :
                return boardRepository.findByBoardCodeAndTelContainingOrderByCreatedAtDesc(boardCode, keyword, pageable)
                        .map(CounseltationResult :: from);
            case "region" :
                return boardRepository.findByBoardCodeAndRegionContainingOrderByCreatedAtDesc(boardCode, keyword, pageable)
                        .map(CounseltationResult :: from);
            default:
                return boardRepository.findByBoardCodeOrderByCreatedAtDesc(boardCode, pageable)
                        .map(CounseltationResult :: from);
        }
    }
}
