package com.project.hajju.boardmybatis.service;

import com.project.hajju.boardmybatis.common.FileUtils;
import com.project.hajju.boardmybatis.dto.BoardDto;
import com.project.hajju.boardmybatis.dto.BoardFileDto;
import com.project.hajju.boardmybatis.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final FileUtils fileUtils;

    public void save(BoardDto boardDto) throws IOException {
        if (boardDto.getBoardFile().isEmpty()) {
            boardRepository.save(boardDto);
        } else {
            boardDto.setFileAttached(1);
            BoardDto savedBoard = boardRepository.save(boardDto);
            MultipartFile boardFile = savedBoard.getBoardFile();

            String originalFileName = boardFile.getOriginalFilename();
            String storedFileName = fileUtils.getStoredFileName(originalFileName);
            BoardFileDto boardFileDto = BoardFileDto.createBoardFileDto(savedBoard, originalFileName, storedFileName);

            // 디렉토리에 파일 저장.
            boardFile.transferTo(new File(fileUtils.savePath(storedFileName)));
            // DB에 저장.
            boardRepository.saveFile(boardFileDto);

        }

    }

    public List<BoardDto> findAll() {
        return boardRepository.findAll();
    }

    public void updateHits(Long id) {
        boardRepository.updateHits(id);
    }

    public BoardDto findById(Long id) {
        return boardRepository.findById(id);
    }

    public void update(BoardDto boardDto) {
        boardRepository.update(boardDto);
    }

    public void delete(Long id) {
        boardRepository.delete(id);
    }

    public BoardFileDto findFile(Long id) {
        return boardRepository.findFile(id);
    }
}
