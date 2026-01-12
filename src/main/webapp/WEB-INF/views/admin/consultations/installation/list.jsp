<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <title>상담 신청</title>
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
        <%@ include file="/WEB-INF/views/admin/layout/header.jsp" %>

        <!-- Controls -->
        <form id="searchForm" method="get" action="/admin/consultations/${typeCode}">
        <div class="board-controls">
            <div class="search-section">
                <select id="typeSelect" class="select-box">
                    <option value="name" ${param.type == 'writer' ? 'selected' : ''}>고객명</option>
                    <option value="region" ${param.type == 'region' ? 'selected' : ''}>지역</option>
                    <option value="content" ${param.type == 'content' ? 'selected' : ''}>내용</option>
                    <option value="email" ${param.type == 'email' ? 'selected' : ''}>이메일</option>
                    <option value="tel" ${param.type == 'tel' ? 'selected' : ''}>연락처</option>
                </select>
                <input id="keywordInput" class="search-input" placeholder="검색어를 입력하세요" value="${param.keyword}">
                <button type="button" class="search-btn" onclick="search()">🔍</button>
            </div>
        </div>
            <input id="typeCode" type="hidden" name="typeCode" value="${typeCode}">
            <input id="type" type="hidden" name="type" value="${param.type}">
            <input id="keyword" type="hidden" name="keyword" value="${param.keyword}">
            <input id="page" type="hidden" name="page" value="${page.number}">
        </form>

        <!-- Table -->
        <div class="board-table-section">
            <table class="board-table">
                <thead>
                <tr>
                    <th>번호</th>
                    <th>고객명</th>
                    <th>지역</th>
                    <th>내용</th>
                    <th>연락처</th>
                    <th>이메일</th>
                    <th>등록일</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="pinData" items="${pinConsultationList}" varStatus="status">
                <tr class="notice-row">

                    <td>📌</td>
                    <td>${pinData.name}</td>
                    <td>${pinData.region}</td>
                    <td><a href="/admin/consultations/${typeCode}/${pinData.consultationId}?currentPage=${page.number}&type=${param.type}&keyword=${param.keyword}" >📋
                        <c:choose>
                            <c:when test="${fn:length(pinData.content) > 50}">
                                ${fn:substring(pinData.content, 0, 50)}...
                            </c:when>
                            <c:otherwise>
                                ${pinData.content}
                            </c:otherwise>
                        </c:choose>
                    </a></td>
                    <td>${pinData.phone}</td>
                    <td>${pinData.email}</td>
                    <td>${pinData.createdAt}</td>
                </tr>
                </c:forEach>
                <c:forEach var="item" items="${page.content}" varStatus="status">
                    <c:set var="rowNum" value="${page.totalElements - (page.number * page.size) - status.index}" />
                    <tr class="notice-row">
                        <td>${rowNum}</td>
                        <td>${item.name}</td>
                        <td>${item.region}</td>
                        <td><a href="/admin/consultations/${typeCode}/${item.consultationId}?currentPage=${page.number}&type=${param.type}&keyword=${param.keyword}">📋
                            <c:choose>
                                <c:when test="${fn:length(item.content) > 50}">
                                    ${fn:substring(item.content, 0, 50)}...
                                </c:when>
                                <c:otherwise>
                                    ${item.content}
                                </c:otherwise>
                            </c:choose>
                        </a></td>
                        <td>${item.phone}</td>
                        <td>${item.email}</td>
                        <td>${item.createdAt}</td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
            <div class="pagination">
                <button class="page-btn">«</button>
                <button class="page-btn">‹</button>
                <c:forEach begin="1" end="${page.totalPages}" var="i">

                    <button class="page-btn ${page.number == i-1 ? 'active' : ''}"
                        onclick="goPage(${i - 1})">
                            ${i}
                    </button>
                </c:forEach>
                <button class="page-btn">›</button>
                <button class="page-btn">»</button>
            </div>
        </div>

    </main>



</div>

<script>
    function search() {
        document.getElementById('keyword').value = document.getElementById('keywordInput').value;
        document.getElementById('type').value = document.getElementById('typeSelect').value;
        document.querySelector('input[name=page]').value = 0;
        document.getElementById('searchForm').submit();
    }

    function goPage(p) {
        document.querySelector('input[name=page]').value = p;
        document.getElementById('searchForm').submit();
    }

    document.getElementById("searchForm").addEventListener("keydown", function (e) {
        if (e.key === "Enter") {
            search();
        }
    });
</script>
</body>
</html>
