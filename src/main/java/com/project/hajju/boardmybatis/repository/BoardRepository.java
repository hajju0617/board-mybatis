package com.project.hajju.boardmybatis.repository;

import com.project.hajju.boardmybatis.dto.BoardDto;
import com.project.hajju.boardmybatis.dto.BoardFileDto;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {
    // myBatis에서 제공하는 SqlSessionTemplate 클래스.
    private final SqlSessionTemplate sql;

    public BoardDto save(BoardDto boardDto) {
        // 여기서 board는 board-mapper의 namespace, save는 id를 뜻함. boardDto는 인자.
        sql.insert("board.save", boardDto);
        return boardDto;
    }

    public List<BoardDto> findAll() {
        return sql.selectList("board.findAll");
    }

    public void updateHits(Long id) {
        sql.update("board.updateHits", id);
    }

    public BoardDto findById(Long id) {
        return sql.selectOne("board.findById", id);
    }

    public void update(BoardDto boardDto) {
        sql.update("board.update", boardDto);
    }

    public void delete(Long id) {
        sql.delete("board.delete", id);
    }

    public void saveFile(BoardFileDto boardFileDto) {
        sql.insert("board.saveFile", boardFileDto);
    }

    public List<BoardFileDto> findFile(Long id) {
        return sql.selectList("board.findFile", id);
    }
}
