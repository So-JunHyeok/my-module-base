package com.example.base.common.code.repository;

import com.example.base.common.code.domain.CommonCode;
import com.example.base.common.code.domain.CommonCodeGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommonCodeGroupRepository extends JpaRepository<CommonCodeGroup, String> {

}
