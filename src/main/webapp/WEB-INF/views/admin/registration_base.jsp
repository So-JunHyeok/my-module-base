<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Modal Popup - 새 글 작성 -->
<div class="modal-close" id="${param.modalId}">
    <div class="modal-container">
        <div class="modal-header">
            <h3 class="modal-title"><c:out value="${param.title}"/></h3>
            <button class="modal-bnt-close" type="button">✕</button>
        </div>

        <div class="modal-body" id="${param.groupCode}">
            <div class="form-group">
                <label class="form-label">시공 파트 *</label>
                <select class="form-select" id="form-select">
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
<script>

    document.getElementById('openModalBtn')
        .addEventListener('click', function () {
            toggleModal('partSelectModal');
        });

    function toggleModal(id) {
        const modal = document.getElementById(id);

        if (modal.classList.contains('modal-overlay')) {
            // 이미 열려 있으면 → 닫기
            closeModal(id);
        } else {
            // 닫혀 있으면 → 열기
            openModal(id);

        }
    }

    function openModal(id) {
        document.getElementById(id).classList.remove('modal-close');
        document.getElementById(id).classList.add('modal-overlay');
        loadCodes(id, 'construction_part');
    }

    function closeModal(id) {
        document.getElementById(id).classList.remove('modal-overlay');
        document.getElementById(id).classList.add('modal-close');
    }

    function loadCodes(modalId, groupCode) {
        fetch(`/api/common/codes?groupCode=`+groupCode)
            .then(res => res.json())
            .then(list => {
                const select = document.getElementById(`form-select`);
                select.innerHTML = '';

                list.forEach(code => {
                    const opt = document.createElement('option');
                    opt.value = code.code;
                    opt.textContent = code.codeName;
                    select.appendChild(opt);
                });
            });
    }
</script>
