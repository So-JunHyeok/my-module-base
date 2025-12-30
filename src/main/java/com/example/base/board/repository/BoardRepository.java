package com.example.base.board.repository;

import com.example.base.board.domain.Board;
import com.example.base.security.user.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {

    /* 목록 */
    Page<Board> findByBoardCodeOrderByCreatedAtDesc(
            Integer boardCode, Pageable pageable);

    Page<Board> findByBoardCodeAndWriterContainingOrderByCreatedAtDesc(
            Integer boardCode, String writer, Pageable pageable);

    Page<Board> findByBoardCodeAndContentContainingOrderByCreatedAtDesc(
            Integer boardCode, String content, Pageable pageable);

    Page<Board> findByBoardCodeAndEmailContainingOrderByCreatedAtDesc(
            Integer boardCode, String email, Pageable pageable);

    Page<Board> findByBoardCodeAndTelContainingOrderByCreatedAtDesc(
            Integer boardCode, String tel, Pageable pageable);

    Page<Board> findByBoardCodeAndRegionContainingOrderByCreatedAtDesc(
            Integer boardCode, String region, Pageable pageable);

    /* 상세 */
    Optional <Board> findByBoardIdAndBoardCode(int boardId, int boardCode);

    // 이전글(아이디 기준)
    Optional<Board> findFirstByBoardCodeAndBoardIdLessThanOrderByBoardIdDesc(int boardCode, Long boardId);

    // 다음글(아이디 기준)
    Optional<Board> findFirstByBoardCodeAndBoardIdGreaterThanOrderByBoardIdAsc(int boardCode, Long boardId);

    // 이전글(등록일 기준)
    Optional<Board> findFirstByBoardCodeAndCreatedAtBeforeOrderByCreatedAtDesc(int boardCode, LocalDateTime createdAt);

    // 다음글(등록일 기준)
    Optional<Board> findFirstByBoardCodeAndCreatedAtAfterOrderByCreatedAtAsc(int boardCode, LocalDateTime createdAt);

    //고정글 관련
    long countByBoardCodeAndPinnedTrue(int boardCode);

    List<Board> findTop3ByBoardCodeAndPinnedTrueOrderByPinnedAtDesc(int boardCode);
}

/*
findAll();                         // 전체 조회
findById(Long id);                 // 단건 조회
existsById(Long id);               // 존재 여부
count();                           // 개수
findAll(Pageable pageable);        // 페이징 조회
 */