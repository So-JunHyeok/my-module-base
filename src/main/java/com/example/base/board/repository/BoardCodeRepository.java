package com.example.base.board.repository;

import com.example.base.board.domain.Board;
import com.example.base.board.domain.BoardCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardCodeRepository extends JpaRepository<BoardCode, Long> {
   Optional<BoardCode> findByBoardCode(int boardCode);
}
