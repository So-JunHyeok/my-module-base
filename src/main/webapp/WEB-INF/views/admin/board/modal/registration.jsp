<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- Modal Popup - 새 글 작성 -->

<head>
    <meta charset="UTF-8" />
    <title>상담 신청</title>
    <link rel="stylesheet" href="/css/admin/modal/registration.css" />
</head>

<div class="modal-overlay">
    <div class="modal-container">
        <div class="modal-header">
            <h3 class="modal-title">새 글 작성</h3>
            <button class="modal-close" type="button">✕</button>
        </div>

        <div class="modal-body">
            <div class="form-group">
                <label class="form-label">카테고리 *</label>
                <select class="form-select">
                    <option>카테고리를 선택하세요</option>
                    <option>공지사항</option>
                    <option>자유게시판</option>
                    <option>FAQ</option>
                    <option>Q&A</option>
                </select>
            </div>

            <div class="form-group">
                <label class="form-label">제목 *</label>
                <input
                        type="text"
                        class="form-input"
                        placeholder="제목을 입력하세요"
                />
            </div>

            <div class="form-group">
                <label class="form-label">작성자 *</label>
                <input
                        type="text"
                        class="form-input"
                        value="관리자"
                        disabled
                />
            </div>

            <div class="form-group">
                <label class="form-label">내용 *</label>
                <textarea
                        class="form-textarea"
                        placeholder="내용을 입력하세요"
                        rows="10"
                ></textarea>
            </div>

            <div class="form-group">
                <label class="form-label">첨부파일</label>
                <div class="file-upload-area">
                    <input type="file" id="file-input" class="file-input" multiple />
                    <label for="file-input" class="file-upload-label">
                        <span class="upload-icon">📎</span>
                        <span>파일을 선택하거나 드래그하세요</span>
                        <span class="file-info">최대 10MB, 최대 5개 파일</span>
                    </label>
                </div>

                <div class="file-list">
                    <!-- 선택된 파일 목록 예시 -->
                    <div class="file-item">
                        <span class="file-name">📄 example.pdf</span>
                        <button class="file-remove" type="button">✕</button>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <div class="checkbox-group">
                    <input type="checkbox" id="notice-check" class="form-checkbox" />
                    <label for="notice-check" class="checkbox-label">
                        공지사항으로 등록
                    </label>
                </div>
            </div>

            <div class="form-group">
                <div class="checkbox-group">
                    <input type="checkbox" id="publish-check" class="form-checkbox" checked />
                    <label for="publish-check" class="checkbox-label">
                        즉시 게시
                    </label>
                </div>
            </div>
        </div>

        <div class="modal-footer">
            <button class="modal-btn btn-cancel" type="button">취소</button>
            <button class="modal-btn btn-save" type="button">임시저장</button>
            <button class="modal-btn btn-submit" type="button">등록하기</button>
        </div>
    </div>
</div>
