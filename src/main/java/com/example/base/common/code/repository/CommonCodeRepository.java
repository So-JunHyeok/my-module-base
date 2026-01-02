package com.example.base.common.code.repository;

import com.example.base.common.code.domain.CommonCode;
import com.example.base.common.code.domain.CommonCodeId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommonCodeRepository extends JpaRepository<CommonCode, CommonCodeId> {
    List<CommonCode> findByIdGroupCode(String groupCode);
}
