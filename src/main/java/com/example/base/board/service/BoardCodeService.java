package com.example.base.board.service;

import com.example.base.board.domain.BoardCode;

import com.example.base.board.repository.BoardCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardCodeService {

    private final BoardCodeRepository boardCodeRepository;

    public Optional<BoardCode> findBoardDetail(String boardCode){
            return boardCodeRepository.findByBoardCode(boardCode);
    }
}
