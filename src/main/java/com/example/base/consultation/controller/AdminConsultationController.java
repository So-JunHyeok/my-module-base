package com.example.base.consultation.controller;

import com.example.base.board.dto.BoardSearchParam;
import com.example.base.consultation.dto.ConsultationResult;
import com.example.base.consultation.dto.ConsultationSearchParam;
import com.example.base.consultation.service.ConsultationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/consultations")
public class AdminConsultationController {

    private final ConsultationService consultationService;

    @GetMapping("/{typeCode}")
    public String consultationSearch(@PathVariable String typeCode, ConsultationSearchParam param, @PageableDefault(size = 10) Pageable pageable, Model model){
        param.setTypeCode(typeCode);

        Page<ConsultationResult> page = consultationService.consultationSearch(param, pageable);
        List<ConsultationResult> pinConsultationList = consultationService.pinConsultationList(param.getTypeCode());

        model.addAttribute("page", page);
        model.addAttribute("pinConsultationList", pinConsultationList);
        model.addAttribute("typeCode", typeCode);
        return "admin/consultations/installation/list";
    }

    @GetMapping("/{typeCode}/{consultationId}")
    public String consultationDetail(@PathVariable String typeCode, @PathVariable Long consultationId,
                                     ConsultationSearchParam param, Model model){

        ConsultationResult data = consultationService.consultationData(typeCode, consultationId);

        model.addAttribute("data", data);
        model.addAttribute("searchParam",param);
        model.addAttribute("typeCode",typeCode);

        return "admin/consultations/"+typeCode+"/detail";
    }

    @PostMapping("pinned")
    public String togglePin(ConsultationSearchParam param, RedirectAttributes ra){
        boolean pinned = consultationService.togglePin(param.getConsultationId(), param.getTypeCode());

        ra.addFlashAttribute(
                "msg",
                pinned ? "고정되었습니다." : "고정 해제되었습니다."
        );

        return "redirect:/admin/consultations/"
                + param.getTypeCode() + "/"
                + param.getConsultationId()
                + "?currentPage=" + param.getCurrentPage()
                + (param.getType() != null ? "&type=" + param.getType() : "")
                + (param.getKeyword() != null ? "&keyword=" + param.getKeyword() : "");

    }
}
