<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <title>관리자 앨범형 게시판</title>
    <link rel="stylesheet" href="/css/admin/heard.css" />
    <link rel="stylesheet" href="/css/admin/construction.css" />
    <!-- 모달 css-->
    <link rel="stylesheet" href="/css/admin/modal/registration.css" />
</head>
<body>

<div class="admin-dashboard">

    <!-- Sidebar -->
    <%@ include file="/WEB-INF/views/admin/layout/sidebar.jsp" %>

    <!-- Main Content -->
    <main class="main-content">

        <header class="content-header">
            <h2 class="page-title">앨범형 게시판</h2>
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

        <!-- Album Controls -->
        <div class="album-controls">
            <div class="control-left">
                <select class="select-box">
                    <option>전체 카테고리</option>
                    <option>제품</option>
                    <option>음식</option>
                    <option>패션</option>
                    <option>여행</option>
                    <option>인테리어</option>
                </select>
                <select class="select-box">
                    <option>최신순</option>
                    <option>인기순</option>
                    <option>조회순</option>
                    <option>댓글순</option>
                </select>
                <div class="search-input-wrapper">
                    <input type="text" class="search-input" placeholder="검색어를 입력하세요" />
                    <button class="search-btn">🔍</button>
                </div>
            </div>
            <div class="control-right">
                <button class="btn-primary" id="openModalBtn">새 사진 등록</button>
            </div>
        </div>

        <!-- Album Stats -->
        <div class="album-stats">
            <div class="stat-box"><span class="stat-icon">📷</span><div class="stat-info"><span class="stat-label">전체 사진</span><span class="stat-value">324</span></div></div>
            <div class="stat-box"><span class="stat-icon">👁️</span><div class="stat-info"><span class="stat-label">전체 조회</span><span class="stat-value">12,456</span></div></div>
            <div class="stat-box"><span class="stat-icon">❤️</span><div class="stat-info"><span class="stat-label">좋아요</span><span class="stat-value">1,847</span></div></div>
            <div class="stat-box"><span class="stat-icon">💬</span><div class="stat-info"><span class="stat-label">댓글</span><span class="stat-value">562</span></div></div>
        </div>

        <!-- Album Grid -->
        <div class="album-container">
            <div class="album-grid">
                    <!-- Album Item 1 -->
                    <div class="album-item">
                        <div class="album-image-wrapper">
                            <img src="https://images.unsplash.com/photo-1611930022073-b7a4ba5fcccd?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w3Nzg4Nzd8MHwxfHNlYXJjaHwxfHxwcm9kdWN0JTIwcGhvdG9ncmFwaHl8ZW58MXx8fHwxNzY3MTQ1MjIzfDA&ixlib=rb-4.1.0&q=80&w=1080"
                                 alt="제품 사진" class="album-image" />
                            <div class="album-overlay">
                                <div class="overlay-info">
                                    <span class="overlay-item">👁️ 234</span>
                                    <span class="overlay-item">❤️ 45</span>
                                </div>
                                <button class="overlay-btn">상세보기</button>
                            </div>
                            <span class="album-badge new">NEW</span>
                        </div>
                        <div class="album-info">
                            <h3 class="album-title">신제품 촬영 스케치</h3>
                            <div class="album-meta">
                                <span class="category-tag product">제품</span>
                                <span class="meta-text">관리자</span>
                                <span class="meta-text">2025-12-25</span>
                            </div>
                        </div>
                    </div>

                    <!-- Album Item 2 -->
                    <div class="album-item">
                        <div class="album-image-wrapper">
                            <img src="https://images.unsplash.com/photo-1568901346375-23c9450c58cd?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w3Nzg4Nzd8MHwxfHNlYXJjaHwxfHxmb29kJTIwcGhvdG9ncmFwaHl8ZW58MXx8fHwxNzY3MTcxOTU4fDA&ixlib=rb-4.1.0&q=80&w=1080"
                                 alt="음식 사진" class="album-image" />
                            <div class="album-overlay">
                                <div class="overlay-info">
                                    <span class="overlay-item">👁️ 456</span>
                                    <span class="overlay-item">❤️ 89</span>
                                </div>
                                <button class="overlay-btn">상세보기</button>
                            </div>
                        </div>
                        <div class="album-info">
                            <h3 class="album-title">브런치 메뉴 촬영</h3>
                            <div class="album-meta">
                                <span class="category-tag food">음식</span>
                                <span class="meta-text">김철수</span>
                                <span class="meta-text">2025-12-24</span>
                            </div>
                        </div>
                    </div>

                    <!-- Album Item 3 -->
                    <div class="album-item">
                        <div class="album-image-wrapper">
                            <img src="https://images.unsplash.com/photo-1704208316515-a32f81e373ef?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w3Nzg4Nzd8MHwxfHxmYXNoaW9uJTIwcGhvdG9ncmFwaHl8ZW58MXx8fHwxNzY3MDgyODM5fDA&ixlib=rb-4.1.0&q=80&w=1080"
                                 alt="패션 사진" class="album-image" />
                            <div class="album-overlay">
                                <div class="overlay-info">
                                    <span class="overlay-item">👁️ 678</span>
                                    <span class="overlay-item">❤️ 123</span>
                                </div>
                                <button class="overlay-btn">상세보기</button>
                            </div>
                            <span class="album-badge popular">HOT</span>
                        </div>
                        <div class="album-info">
                            <h3 class="album-title">2025 봄 컬렉션</h3>
                            <div class="album-meta">
                                <span class="category-tag fashion">패션</span>
                                <span class="meta-text">이영희</span>
                                <span class="meta-text">2025-12-23</span>
                            </div>
                        </div>
                    </div>

                    <!-- Album Item 4 -->
                    <div class="album-item">
                        <div class="album-image-wrapper">
                            <img src="https://images.unsplash.com/photo-1617634667039-8e4cb277ab46?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w3Nzg4Nzd8MHwxfHxuYXR1cmUlMjBsYW5kc2NhcGV8ZW58MXx8fHwxNzY3MTM4ODYwfDA&ixlib=rb-4.1.0&q=80&w=1080"
                                 alt="자연 사진" class="album-image" />
                            <div class="album-overlay">
                                <div class="overlay-info">
                                    <span class="overlay-item">👁️ 345</span>
                                    <span class="overlay-item">❤️ 67</span>
                                </div>
                                <button class="overlay-btn">상세보기</button>
                            </div>
                        </div>
                        <div class="album-info">
                            <h3 class="album-title">자연 풍경 모음</h3>
                            <div class="album-meta">
                                <span class="category-tag travel">여행</span>
                                <span class="meta-text">박지민</span>
                                <span class="meta-text">2025-12-22</span>
                            </div>
                        </div>
                    </div>

                    <!-- Album Item 5 -->
                    <div class="album-item">
                        <div class="album-image-wrapper">
                            <img src="https://images.unsplash.com/photo-1628130235364-9e412ffaae5a?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w3Nzg4Nzd8MHwxfHx0ZWNobm9sb2d5JTIwZ2FkZ2V0fGVufDF8fHx8MTc2NzA4ODQ3NHww&ixlib=rb-4.1.0&q=80&w=1080"
                                 alt="기술 사진" class="album-image" />
                            <div class="album-overlay">
                                <div class="overlay-info">
                                    <span class="overlay-item">👁️ 523</span>
                                    <span class="overlay-item">❤️ 98</span>
                                </div>
                                <button class="overlay-btn">상세보기</button>
                            </div>
                        </div>
                        <div class="album-info">
                            <h3 class="album-title">최신 기기 리뷰</h3>
                            <div class="album-meta">
                                <span class="category-tag product">제품</span>
                                <span class="meta-text">최수진</span>
                                <span class="meta-text">2025-12-21</span>
                            </div>
                        </div>
                    </div>

                    <!-- Album Item 6 -->
                    <div class="album-item">
                        <div class="album-image-wrapper">
                            <img src="https://images.unsplash.com/photo-1618221195710-dd6b41faaea6?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w3Nzg4Nzd8MHwxfHxpbnRlcmlvciUyMGRlc2lnbnxlbnwxfHx8fDE3NjcxNjUzMzF8MA&ixlib=rb-4.1.0&q=80&w=1080"
                                 alt="인테리어 사진" class="album-image" />
                            <div class="album-overlay">
                                <div class="overlay-info">
                                    <span class="overlay-item">👁️ 789</span>
                                    <span class="overlay-item">❤️ 145</span>
                                </div>
                                <button class="overlay-btn">상세보기</button>
                            </div>
                        </div>
                        <div class="album-info">
                            <h3 class="album-title">모던 인테리어 디자인</h3>
                            <div class="album-meta">
                                <span class="category-tag interior">인테리어</span>
                                <span class="meta-text">정민호</span>
                                <span class="meta-text">2025-12-20</span>
                            </div>
                        </div>
                    </div>

                    <!-- Album Item 7 -->
                    <div class="album-item">
                        <div class="album-image-wrapper">
                            <img src="https://images.unsplash.com/photo-1614088459293-5669fadc3448?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w3Nzg4Nzd8MHwxfHx0cmF2ZWwlMjBkZXN0aW5hdGlvbnxlbnwxfHx8fDE3NjcwNzg1ODB8MA&ixlib=rb-4.1.0&q=80&w=1080"
                                 alt="여행 사진" class="album-image" />
                            <div class="album-overlay">
                                <div class="overlay-info">
                                    <span class="overlay-item">👁️ 612</span>
                                    <span class="overlay-item">❤️ 112</span>
                                </div>
                                <button class="overlay-btn">상세보기</button>
                            </div>
                            <span class="album-badge new">NEW</span>
                        </div>
                        <div class="album-info">
                            <h3 class="album-title">유럽 여행 스케치</h3>
                            <div class="album-meta">
                                <span class="category-tag travel">여행</span>
                                <span class="meta-text">강민정</span>
                                <span class="meta-text">2025-12-19</span>
                            </div>
                        </div>
                    </div>

                    <!-- Album Item 8 -->
                    <div class="album-item">
                        <div class="album-image-wrapper">
                            <img src="https://images.unsplash.com/photo-1518998053901-5348d3961a04?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w3Nzg4Nzd8MHwxfHxhcnQlMjBnYWxsZXJ5fGVufDF8fHx8MTc2NzEwOTI2OHww&ixlib=rb-4.1.0&q=80&w=1080"
                                 alt="갤러리 사진" class="album-image" />
                            <div class="album-overlay">
                                <div class="overlay-info">
                                    <span class="overlay-item">👁️ 445</span>
                                    <span class="overlay-item">❤️ 78</span>
                                </div>
                                <button class="overlay-btn">상세보기</button>
                            </div>
                        </div>
                        <div class="album-info">
                            <h3 class="album-title">현대 미술 전시</h3>
                            <div class="album-meta">
                                <span class="category-tag travel">여행</span>
                                <span class="meta-text">윤서연</span>
                                <span class="meta-text">2025-12-18</span>
                            </div>
                        </div>
                    </div>

                    <!-- Album Item 9 -->
                    <div class="album-item">
                        <div class="album-image-wrapper">
                            <img src="https://images.unsplash.com/photo-1453614512568-c4024d13c247?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w3Nzg4Nzd8MHwxfHxjb2ZmZWUlMjBzaG9wfGVufDF8fHx8MTc2NzE3MDM3NHww&ixlib=rb-4.1.0&q=80&w=1080"
                                 alt="카페 사진" class="album-image" />
                            <div class="album-overlay">
                                <div class="overlay-info">
                                    <span class="overlay-item">👁️ 567</span>
                                    <span class="overlay-item">❤️ 92</span>
                                </div>
                                <button class="overlay-btn">상세보기</button>
                            </div>
                        </div>
                        <div class="album-info">
                            <h3 class="album-title">감성 카페 투어</h3>
                            <div class="album-meta">
                                <span class="category-tag food">음식</span>
                                <span class="meta-text">한지우</span>
                                <span class="meta-text">2025-12-17</span>
                            </div>
                        </div>
                    </div>

                    <!-- Album Item 10 -->
                    <div class="album-item">
                        <div class="album-image-wrapper">
                            <img src="https://images.unsplash.com/photo-1700451761308-ec56f93c82be?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w3Nzg4Nzd8MHwxfHx3b3Jrc3BhY2UlMjBkZXNrfGVufDF8fHx8MTc2NzE1Mzc5Nnww&ixlib=rb-4.1.0&q=80&w=1080"
                                 alt="워크스페이스 사진" class="album-image" />
                            <div class="album-overlay">
                                <div class="overlay-info">
                                    <span class="overlay-item">👁️ 398</span>
                                    <span class="overlay-item">❤️ 71</span>
                                </div>
                                <button class="overlay-btn">상세보기</button>
                            </div>
                        </div>
                        <div class="album-info">
                            <h3 class="album-title">홈 오피스 인테리어</h3>
                            <div class="album-meta">
                                <span class="category-tag interior">인테리어</span>
                                <span class="meta-text">송하은</span>
                                <span class="meta-text">2025-12-16</span>
                            </div>
                        </div>
                    </div>

                    <!-- Album Item 11 -->
                    <div class="album-item">
                        <div class="album-image-wrapper">
                            <img src="https://images.unsplash.com/photo-1617381519460-d87050ddeb92?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w3Nzg4Nzd8MHwxfHxjaXR5JTIwYXJjaGl0ZWN0dXJlfGVufDF8fHx8MTc2NzA5NTUxNnww&ixlib=rb-4.1.0&q=80&w=1080"
                                 alt="건축 사진" class="album-image" />
                            <div class="album-overlay">
                                <div class="overlay-info">
                                    <span class="overlay-item">👁️ 724</span>
                                    <span class="overlay-item">❤️ 134</span>
                                </div>
                                <button class="overlay-btn">상세보기</button>
                            </div>
                            <span class="album-badge popular">HOT</span>
                        </div>
                        <div class="album-info">
                            <h3 class="album-title">도시 건축 탐방</h3>
                            <div class="album-meta">
                                <span class="category-tag travel">여행</span>
                                <span class="meta-text">김민수</span>
                                <span class="meta-text">2025-12-15</span>
                            </div>
                        </div>
                    </div>

                    <!-- Album Item 12 -->
                    <div class="album-item">
                        <div class="album-image-wrapper">
                            <img src="https://images.unsplash.com/photo-1495121553079-4c61bcce1894?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w3Nzg4Nzd8MHwxfHx2aW50YWdlJTIwY2FtZXJhfGVufDF8fHx8MTc2NzEwMTIwOXww&ixlib=rb-4.1.0&q=80&w=1080"
                                 alt="카메라 사진" class="album-image" />
                            <div class="album-overlay">
                                <div class="overlay-info">
                                    <span class="overlay-item">👁️ 481</span>
                                    <span class="overlay-item">❤️ 85</span>
                                </div>
                                <button class="overlay-btn">상세보기</button>
                            </div>
                        </div>
                        <div class="album-info">
                            <h3 class="album-title">빈티지 카메라 컬렉션</h3>
                            <div class="album-meta">
                                <span class="category-tag product">제품</span>
                                <span class="meta-text">박서준</span>
                                <span class="meta-text">2025-12-14</span>
                            </div>
                        </div>
                    </div>



            </div>

            <div class="pagination">
                <button class="page-btn">«</button>
                <button class="page-btn">‹</button>
                <button class="page-btn active">1</button>
                <button class="page-btn">2</button>
                <button class="page-btn">3</button>
                <button class="page-btn">4</button>
                <button class="page-btn">5</button>
                <button class="page-btn">›</button>
                <button class="page-btn">»</button>
            </div>
        </div>

    </main>
</div>

<jsp:include page="/WEB-INF/views/admin/board/modal/registration.jsp">
    <jsp:param name="groupCode" value="construction_part"/>
    <jsp:param name="modalId" value="partSelectModal"/>
    <jsp:param name="title" value="시공사례 등록"/>
</jsp:include>
</body>
</html>
