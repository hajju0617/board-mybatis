package com.project.hajju.boardmybatis.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
}
