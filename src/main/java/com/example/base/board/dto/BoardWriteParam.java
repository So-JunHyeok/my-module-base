package com.example.base.board.dto;

import com.example.base.board.domain.FileType;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class BoardWriteParam extends BoardSearchParam{

    // writer | content | email | tel | region
    private String boardCode;
    private String writer;
    private String title;
    private String content;
    private String category;

    private FileType fileType;

    //일반 게시판
    private List<MultipartFile> files;

    //시공사례 전용
    private MultipartFile beforeFile;
    private MultipartFile afterFile;

}
