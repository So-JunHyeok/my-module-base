package com.example.base.common.code.controller;

import com.example.base.common.code.dto.CommonCodeResponse;
import com.example.base.common.code.service.CommonCodeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/api/common")
public class CommonCodeController {

    private final CommonCodeService commonCodeService;
    @GetMapping("codes")
    @ResponseBody
    public List<CommonCodeResponse> getCodes(
            @RequestParam String groupCode
    ) {
        return commonCodeService.commCodeList(groupCode);
    }

}
