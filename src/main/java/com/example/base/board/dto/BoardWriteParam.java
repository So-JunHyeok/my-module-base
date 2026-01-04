package com.example.base.board.dto;

import com.example.base.board.domain.FileType;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
@Data
public class BoardWriteParam extends BoardSearchParam{

    // writer | content | email | tel | region

    private String writer;
    private String title;
    private String content;
    private String email;
    private String tel;
    private String region;
    private String category;

    private FileType fileType;
    private MultipartFile beforeFile;
    private MultipartFile afterFile;

}
