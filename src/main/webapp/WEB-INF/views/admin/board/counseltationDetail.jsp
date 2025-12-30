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
                    <span class="category-badge free">e-mail</span>
                    <span class="status-badge active">${data.email}</span>
                </div>

                <h1 class="post-detail-title">${data.region}지역 상담신청입니다.</h1>

                <div class="post-meta-info">
                    <div class="meta-left">
                        <span class="meta-item">
                          <span class="meta-label">작성자:</span>
                          <span class="meta-value">${data.writer}</span>
                        </span>
                                    <span class="meta-divider">|</span>
                                    <span class="meta-item">
                          <span class="meta-label">작성일:</span>
                          <span class="meta-value">${data.createdAt}</span>
                        </span>
                                    <span class="meta-divider">|</span>
                                    <span class="meta-item">
                          <span class="meta-label">연락처:</span>
                          <span class="meta-value">${data.tel}</span>
                        </span>
                    </div>

                    <div class="meta-right">
                        <button class="action-icon-btn" type="button" onclick="document.getElementById('go_list').submit();">📤</button>
                        <form id="pinBoard" method="post" action="/admin/pinned" style="display:inline;">
                            <input type="hidden" name="page" value="${boardParam.currentPage}">
                            <input type="hidden" name="type" value="${boardParam.type}">
                            <input type="hidden" name="keyword" value="${boardParam.keyword}">
                            <input type="hidden" name="boardId" value="${data.boardId}">
                            <input type="hidden" name="boardCode" value="${data.boardCode}">
                            <button <c:if test="${data.pinned}"> style="background-color: beige"</c:if> type="submit" class="action-icon-btn" type="button">🔖</button>
                        </form>
                        <c:if test="${not empty msg}">
                            <div id="toast" class="toast">📋${msg}</div>
                            <script>
                                setTimeout(() => {
                                    document.getElementById("toast").style.display = "none";
                                }, 2000);
                            </script>
                        </c:if>
                        <!--<button class="action-icon-btn" type="button">📋</button>-->
                    </div>
                </div>
            </div>

            <!-- Post Content -->
            <div class="post-content">
                <div class="content-body">
                    ${data.content}
                </div>

                <!-- Attachments -->
            </div>

            <!-- Action Buttons -->
            <div class="post-actions">
                <div class="actions-left">
                    <form id="go_list" method="get" action="/admin/counseltation" style="display:inline;">
                        <input type="hidden" name="page" value="${boardParam.currentPage}">
                        <input type="hidden" name="type" value="${boardParam.type}">
                        <input type="hidden" name="keyword" value="${boardParam.keyword}">
                        <input type="hidden" name="boardCode" value="${data.boardCode}">
                        <button type="submit" class="btn-action btn-list" type="button">목록으로</button>
                    </form>
                </div>
                <div class="actions-right">

                    <!-- <button class="btn-action btn-edit" type="button">수정</button>-->
                    <button class="btn-action btn-delete" type="button">삭제</button>
                    <button class="btn-action btn-answer" type="button">답변하기</button>
                </div>
            </div>

            <!-- Comments Section -->


            <!-- Navigation - Previous/Next Post -->
            <div class="post-navigation">
                <div class="nav-item prev-post">
                    <span class="nav-label">이전글</span>
                    <c:if test="${data.prev.writer != null}">
                         <a href="/admin/counseltationDetail?boardId=${data.prev.boardId}&currentPage=${boardParam.currentPage}&type=${boardParam.type}&keyword=${boardParam.keyword}" class="nav-link">📌 ${data.prev.writer}님의 상담 요청입니다.</a>
                    </c:if>
                </div>
                <div class="nav-divider"></div>
                <div class="nav-item next-post">
                    <span class="nav-label">다음글</span>
                    <c:if test="${data.next.writer != null}">
                        <a href="/admin/counseltationDetail?boardId=${data.next.boardId}&currentPage=${boardParam.currentPage}&type=${boardParam.type}&keyword=${boardParam.keyword}" class="nav-link">📌 ${data.next.writer}님의 상담요청입니다.</a>
                    </c:if>
                </div>
            </div>
        </div>
    </main>
</div>

</body>
</html>

