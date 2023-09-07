package com.sist.web.dao;

import com.sist.web.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.*;

public interface BoardDAO extends JpaRepository<BoardEntity, Integer> {
    @Query(value = "SELECT * FROM board ORDER BY no DESC LIMIT :start, 10", nativeQuery = true)
    public List<BoardEntity> boardListData(@Param("start") Integer start);

    @Query(value = "SELECT CEIL(COUNT(*)/10.0) FROM board", nativeQuery = true)
    public int boardTotalPage();

    // 상세보기
    public BoardEntity findByNo(int no);
}
