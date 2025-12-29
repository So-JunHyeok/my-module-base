<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <title>관리자 로그인</title>
    <link rel="stylesheet" href="/css/admin/login.css" />
</head>
<body>

<div class="page">
    <div class="card">

        <!-- 헤더 -->
        <div class="card-header">
            <div class="icon-circle">
                🔒
            </div>
            <h1>관리자 로그인</h1>
            <p>관리자 계정으로 로그인하세요</p>
        </div>

        <!-- 폼 -->
        <form method="post" action="/admin/login">
            <div class="field">
                <label for="username">사용자 이름</label>
                <input
                        type="text"
                        id="username"
                        name="username"
                        placeholder="admin"
                />
                <!-- 에러 메시지 -->
                <!-- <div class="error">사용자 이름을 입력해주세요</div> -->
            </div>

            <div class="field">
                <label for="password">비밀번호</label>
                <input
                        type="password"
                        id="password"
                        name="password"
                        placeholder="••••••••"
                />
                <!-- <div class="error">비밀번호를 입력해주세요</div> -->
            </div>

            <button type="submit" class="btn">
                로그인
            </button>
        </form>

        <!-- 데모 계정 -->
        <div class="demo">
            <strong>데모 계정</strong><br />
            사용자 이름: <code>admin</code><br />
            비밀번호: <code>admin123</code>
        </div>

    </div>
</div>

</body>
</html>
