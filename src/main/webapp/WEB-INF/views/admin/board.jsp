<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <title>게시판 관리</title>
    <link rel="stylesheet" href="/css/admin/heard.css" />
    <link rel="stylesheet" href="/css/admin/board.css" />
</head>
<body>

<div class="admin-dashboard">

    <!-- Sidebar -->
    <%@ include file="/WEB-INF/views/admin/layout/sidebar.jsp" %>

    <!-- Main -->
    <main class="main-content">

        <!-- Header -->
        <header class="content-header">
            <h2 class="page-title">게시판 관리</h2>
            <div class="header-actions">
                <button class="notification-btn">
                    🔔 <span class="notification-badge">3</span>
                </button>
                <div class="user-profile">
                    <div class="user-avatar">관</div>
                    <span class="user-name">관리자</span>
                </div>
            </div>
        </header>

        <!-- Controls -->
        <div class="board-controls">
            <div class="search-section">
                <select class="select-box">
                    <option>제목</option>
                    <option>작성자</option>
                    <option>내용</option>
                    <option>제목+내용</option>
                </select>
                <input class="search-input" placeholder="검색어를 입력하세요">
                <button class="search-btn">🔍</button>
            </div>

            <div class="filter-section">
                <select class="select-box">
                    <option>전체 카테고리</option>
                    <option>공지사항</option>
                    <option>자유게시판</option>
                    <option>FAQ</option>
                    <option>Q&A</option>
                </select>
                <button class="btn-primary">새 글 작성</button>
            </div>
        </div>

        <!-- Table -->
        <div class="board-table-section">
            <table class="board-table">
                <thead>
                <tr>
                    <th>번호</th>
                    <th>카테고리</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>조회수</th>
                    <th>작성일</th>
                    <th>상태</th>
                </tr>
                </thead>
                <tbody>
                <tr class="notice-row">
                    <td>공지</td>
                    <td>공지사항</td>
                    <td><a href="#">📌 2025년 새해 맞이 이벤트 안내</a></td>
                    <td>관리자</td>
                    <td>1234</td>
                    <td>2025-12-25</td>
                    <td><span class="status-badge active">게시중</span></td>
                </tr>
                </tbody>
            </table>
        </div>

    </main>
</div>

</body>
</html>
