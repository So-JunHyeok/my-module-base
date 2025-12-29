<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- admin-dashboard.html -->

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <title>상담 신청</title>
    <link rel="stylesheet" href="/css/admin/heard.css" />
    <link rel="stylesheet" href="/css/admin/counseltationDetail.css" />

</head>
<body>
<div class="admin-dashboard">
    <!-- Sidebar -->
    <%@ include file="/WEB-INF/views/admin/layout/sidebar.jsp" %>

    <!-- Main Content -->
    <main class="main-content">
        <!-- Header -->
        <%@ include file="/WEB-INF/views/admin/layout/header.jsp" %>

        <!-- Breadcrumb -->
        <div class="breadcrumb">
            <a href="#" class="breadcrumb-link">게시판 관리</a>
            <span class="breadcrumb-separator">›</span>
            <span class="breadcrumb-current">게시글 상세</span>
        </div>

        <!-- Post Detail Container -->
        <div class="detail-container">
            <!-- Post Header -->
            <div class="post-detail-header">
                <div class="post-meta-top">
                    <span class="category-badge free">자유게시판</span>
                    <span class="status-badge active">게시중</span>
                </div>

                <h1 class="post-detail-title">문의드립니다. 배송 관련 질문입니다.</h1>

                <div class="post-meta-info">
                    <div class="meta-left">
            <span class="meta-item">
              <span class="meta-label">작성자:</span>
              <span class="meta-value">김철수</span>
            </span>
                        <span class="meta-divider">|</span>
                        <span class="meta-item">
              <span class="meta-label">작성일:</span>
              <span class="meta-value">2025-12-25 14:30</span>
            </span>
                        <span class="meta-divider">|</span>
                        <span class="meta-item">
              <span class="meta-label">조회수:</span>
              <span class="meta-value">89</span>
            </span>
                    </div>

                    <div class="meta-right">
                        <button class="action-icon-btn" type="button">📤</button>
                        <button class="action-icon-btn" type="button">🔖</button>
                        <button class="action-icon-btn" type="button">📋</button>
                    </div>
                </div>
            </div>

            <!-- Post Content -->
            <div class="post-content">
                <div class="content-body">
                    <p>안녕하세요. 배송 관련해서 문의드립니다.</p>
                    <br>
                    <p>지난 12월 20일에 주문한 상품이 아직 도착하지 않았습니다.</p>
                    <p>주문번호는 #ORD-1247 입니다.</p>
                    <br>
                    <p>배송 조회를 해보니 현재 배송 중이라고 나오는데, 예상 도착일이 이미 지났습니다.</p>
                    <p>정확한 배송 일정을 알 수 있을까요?</p>
                    <br>
                    <p>빠른 답변 부탁드립니다.</p>
                    <p>감사합니다.</p>
                </div>

                <!-- Attachments -->
                <div class="attachments">
                    <div class="attachment-header">
                        <span class="attachment-icon">📎</span>
                        <span class="attachment-title">첨부파일 (2)</span>
                    </div>

                    <div class="attachment-list">
                        <div class="attachment-item">
                            <span class="file-icon">📄</span>
                            <span class="file-name">주문내역.pdf</span>
                            <span class="file-size">245 KB</span>
                            <button class="file-download" type="button">다운로드</button>
                        </div>
                        <div class="attachment-item">
                            <span class="file-icon">🖼️</span>
                            <span class="file-name">배송조회_스크린샷.png</span>
                            <span class="file-size">1.2 MB</span>
                            <button class="file-download" type="button">다운로드</button>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Action Buttons -->
            <div class="post-actions">
                <div class="actions-left">
                    <button class="btn-action btn-list" type="button">목록으로</button>
                </div>
                <div class="actions-right">
                    <button class="btn-action btn-edit" type="button">수정</button>
                    <button class="btn-action btn-delete" type="button">삭제</button>
                    <button class="btn-action btn-answer" type="button">답변하기</button>
                </div>
            </div>

            <!-- Comments Section -->
            <div class="comments-section">
                <div class="comments-header">
                    <h3 class="comments-title">댓글 <span class="comment-count-badge">5</span></h3>
                </div>

                <!-- Comment Write -->
                <div class="comment-write">
                    <div class="comment-writer-info">
                        <div class="user-avatar small">관</div>
                        <span class="writer-name">관리자</span>
                    </div>
                    <textarea class="comment-input" placeholder="댓글을 입력하세요..." rows="3"></textarea>
                    <div class="comment-actions">
                        <button class="btn-comment-submit" type="button">댓글 등록</button>
                    </div>
                </div>

                <!-- Comment List -->
                <div class="comment-list">
                    <div class="comment-item admin-comment">
                        <div class="comment-avatar">
                            <div class="user-avatar small">관</div>
                        </div>
                        <div class="comment-content">
                            <div class="comment-header">
                                <span class="comment-author">관리자</span>
                                <span class="admin-badge">운영자</span>
                                <span class="comment-date">2025-12-25 15:00</span>
                            </div>
                            <div class="comment-body">
                                <p>안녕하세요. 문의 주신 내용 확인했습니다.</p>
                                <p>배송 일정이 지연된 점 죄송합니다. 현재 배송 기사님께 확인 중이며, 오늘 중으로 배송 완료될 예정입니다.</p>
                            </div>
                            <div class="comment-footer">
                                <button class="comment-btn" type="button">답글</button>
                                <button class="comment-btn" type="button">수정</button>
                                <button class="comment-btn" type="button">삭제</button>
                            </div>
                        </div>
                    </div>

                    <div class="comment-item">
                        <div class="comment-avatar">
                            <div class="user-avatar small">김</div>
                        </div>
                        <div class="comment-content">
                            <div class="comment-header">
                                <span class="comment-author">김철수</span>
                                <span class="comment-date">2025-12-25 15:30</span>
                            </div>
                            <div class="comment-body">
                                <p>빠른 답변 감사합니다! 확인했습니다.</p>
                            </div>
                            <div class="comment-footer">
                                <button class="comment-btn" type="button">답글</button>
                            </div>
                        </div>
                    </div>

                    <div class="comment-item reply-comment">
                        <div class="comment-avatar">
                            <div class="user-avatar small">관</div>
                        </div>
                        <div class="comment-content">
                            <div class="comment-header">
                                <span class="comment-author">관리자</span>
                                <span class="admin-badge">운영자</span>
                                <span class="comment-date">2025-12-25 16:00</span>
                            </div>
                            <div class="comment-body">
                                <p>네, 불편을 드려 죄송합니다. 추가 문의사항 있으시면 언제든 연락 주세요!</p>
                            </div>
                            <div class="comment-footer">
                                <button class="comment-btn" type="button">수정</button>
                                <button class="comment-btn" type="button">삭제</button>
                            </div>
                        </div>
                    </div>

                    <div class="comment-item">
                        <div class="comment-avatar">
                            <div class="user-avatar small">이</div>
                        </div>
                        <div class="comment-content">
                            <div class="comment-header">
                                <span class="comment-author">이영희</span>
                                <span class="comment-date">2025-12-25 17:00</span>
                            </div>
                            <div class="comment-body">
                                <p>저도 비슷한 문제가 있었는데 도움이 되네요!</p>
                            </div>
                            <div class="comment-footer">
                                <button class="comment-btn" type="button">답글</button>
                            </div>
                        </div>
                    </div>

                    <div class="comment-item">
                        <div class="comment-avatar">
                            <div class="user-avatar small">박</div>
                        </div>
                        <div class="comment-content">
                            <div class="comment-header">
                                <span class="comment-author">박지민</span>
                                <span class="comment-date">2025-12-25 18:00</span>
                            </div>
                            <div class="comment-body">
                                <p>친절한 응대 감사합니다.</p>
                            </div>
                            <div class="comment-footer">
                                <button class="comment-btn" type="button">답글</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Navigation - Previous/Next Post -->
            <div class="post-navigation">
                <div class="nav-item prev-post">
                    <span class="nav-label">이전글</span>
                    <a href="#" class="nav-link">회원가입 후 로그인이 안됩니다</a>
                </div>
                <div class="nav-divider"></div>
                <div class="nav-item next-post">
                    <span class="nav-label">다음글</span>
                    <a href="#" class="nav-link">📌 2025년 새해 맞이 이벤트 안내</a>
                </div>
            </div>
        </div>
    </main>
</div>
</body>
</html>

