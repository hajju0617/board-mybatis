package com.project.hajju.boardmybatis.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
public class BoardDto {
    private long id;
    private String boardTitle;
    private String boardContent;
    private String boardWriter;
    private int boardHits;
    private String createdAt;
    private String boardPassword;
    private int fileAttached;
    private MultipartFile boardFile;
}
