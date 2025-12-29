package com.example.base.board.repository;

import com.example.base.board.domain.Board;
import com.example.base.security.user.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {

    Page<Board> findByBoardCodeOrderByCreatedAtDesc(
            String boardCode, Pageable pageable);

    Page<Board> findByBoardCodeAndWriterContainingOrderByCreatedAtDesc(
            String boardCode, String writer, Pageable pageable);

    Page<Board> findByBoardCodeAndContentContainingOrderByCreatedAtDesc(
            String boardCode, String content, Pageable pageable);

    Page<Board> findByBoardCodeAndEmailContainingOrderByCreatedAtDesc(
            String boardCode, String email, Pageable pageable);

    Page<Board> findByBoardCodeAndTelContainingOrderByCreatedAtDesc(
            String boardCode, String tel, Pageable pageable);

    Page<Board> findByBoardCodeAndRegionContainingOrderByCreatedAtDesc(
            String boardCode, String region, Pageable pageable);
}

/*
findAll();                         // 전체 조회
findById(Long id);                 // 단건 조회
existsById(Long id);               // 존재 여부
count();                           // 개수
findAll(Pageable pageable);        // 페이징 조회
 */