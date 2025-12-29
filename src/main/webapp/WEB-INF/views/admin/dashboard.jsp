<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <title>관리자 대시보드</title>
    <link rel="stylesheet" href="/css/admin/heard.css" />
    <link rel="stylesheet" href="/css/admin/dashboard.css" />

</head>
<body>
<div class="admin-dashboard">
    <!-- Sidebar -->
    <%@ include file="/WEB-INF/views/admin/layout/sidebar.jsp" %>

    <!-- Main Content -->
    <main class="main-content">
        <!-- Header -->
        <header class="content-header">
            <h2 class="page-title">대시보드</h2>
            <div class="header-actions">
                <button class="notification-btn">
                    🔔
                    <span class="notification-badge">3</span>
                </button>
                <div class="user-profile">
                    <div class="user-avatar">관</div>
                    <span class="user-name">관리자</span>
                </div>
            </div>
        </header>

        <!-- Stats Cards -->
        <div class="stats-grid">
            <div class="stat-card">
                <div class="stat-icon blue">👥</div>
                <div class="stat-info">
                    <p class="stat-label">총 방문자</p>
                    <p class="stat-value">1,234</p>
                    <p class="stat-change positive">+12명 이번 달</p>
                </div>
            </div>

            <div class="stat-card">
                <div class="stat-icon green">💰</div>
                <div class="stat-info">
                    <p class="stat-label">AI 사용료</p>
                    <p class="stat-value">₩50,000</p>
                    <p class="stat-change positive">+5회 이번 달</p>
                </div>
            </div>

            <div class="stat-card">
                <div class="stat-icon orange">📦</div>
                <div class="stat-info">
                    <p class="stat-label">신규 상담</p>
                    <p class="stat-value">3</p>
                    <p class="stat-change positive">+23% 지난 달 대비</p>
                </div>
            </div>

            <div class="stat-card">
                <div class="stat-icon purple">⭐</div>
                <div class="stat-info">
                    <p class="stat-label">AI API 임계치</p>
                    <p class="stat-value">5/500</p>
                    <p class="stat-change positive">+495 잔여 수</p>
                </div>
            </div>
        </div>

        <!-- Charts Section
        <div class="charts-section">
            <div class="chart-card">
                <h3 class="chart-title">월별 매출 추이</h3>
                <div class="chart-placeholder">
                    <div class="bar-chart">
                        <div class="bar" style="height: 60%"><span class="bar-label">1월</span></div>
                        <div class="bar" style="height: 75%"><span class="bar-label">2월</span></div>
                        <div class="bar" style="height: 55%"><span class="bar-label">3월</span></div>
                        <div class="bar" style="height: 85%"><span class="bar-label">4월</span></div>
                        <div class="bar" style="height: 70%"><span class="bar-label">5월</span></div>
                        <div class="bar" style="height: 90%"><span class="bar-label">6월</span></div>
                    </div>
                </div>
            </div>

            <div class="chart-card">
                <h3 class="chart-title">카테고리별 판매</h3>
                <div class="chart-placeholder">
                    <div class="pie-chart">
                        <div class="pie-item">
                            <div class="pie-color blue"></div>
                            <span>전자제품 (35%)</span>
                        </div>
                        <div class="pie-item">
                            <div class="pie-color green"></div>
                            <span>의류 (28%)</span>
                        </div>
                        <div class="pie-item">
                            <div class="pie-color orange"></div>
                            <span>식품 (22%)</span>
                        </div>
                        <div class="pie-item">
                            <div class="pie-color purple"></div>
                            <span>기타 (15%)</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
         -->
        <!-- Recent Orders Table -->
        <div class="table-section">
            <h3 class="section-title">최근 상담</h3>
            <div class="table-container">
                <table class="data-table">
                    <thead>
                    <tr>
                        <th>상담번호</th>
                        <th>고객명</th>
                        <th>연락처</th>
                        <th>이메일</th>
                        <th>시공지역</th>
                        <th>처리상태</th>
                        <th>등록일</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>5</td>
                        <td>김철수</td>
                        <td>-</td>
                        <td>test@naver.com</td>
                        <td>서울</td>
                        <td><span class="status-badge pending">등록</span></td>
                        <td>2025-12-25</td>
                    </tr>
                    <tr>
                        <td>4</td>
                        <td>이영희</td>
                        <td>-</td>
                        <td>test1@naver.com</td>
                        <td>서울</td>
                        <td><span class="status-badge pending">등록</span></td>
                        <td>2025-12-25</td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>박지민</td>
                        <td>-</td>
                        <td>test2@naver.com</td>
                        <td>서울</td>
                        <td><span class="status-badge completed">완료</span></td>
                        <td>2025-12-25</td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>최수진</td>
                        <td>-</td>
                        <td>test2@naver.com</td>
                        <td>서울</td>
                        <td><span class="status-badge completed">완료</span></td>
                        <td>2025-12-25</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>정민호</td>
                        <td>-</td>
                        <td>test2@naver.com</td>
                        <td>서울</td>
                        <td><span class="status-badge completed">완료</span></td>
                        <td>2025-12-25</td>
                    </tr>
                    </tbody>
                </table>
                <!--
                <td><span class="status-badge completed">완료</span></td>
                <td><span class="status-badge processing">처리중</span></td>
                <td><span class="status-badge pending">대기</span></td>
                -->

            </div>
        </div>
    </main>
</div>

</body>