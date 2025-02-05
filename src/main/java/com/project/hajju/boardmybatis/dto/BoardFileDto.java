package com.project.hajju.boardmybatis.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BoardFileDto {
    private Long id;
    private Long boardId;
    private String originalFileName;    // 원본 이름.
    private String storedFileName;      // 업로드 시 이름.

    public BoardFileDto(Long boardId, String originalFileName, String storedFileName) {
        this.boardId = boardId;
        this.originalFileName = originalFileName;
        this.storedFileName = storedFileName;
    }


    public static BoardFileDto createBoardFileDto(BoardDto boardDto, String originalFileName, String storedFileName) {
        return new BoardFileDto(
                  boardDto.getId()
                , originalFileName
                , storedFileName
        );
    }
}
