package com.sist.web.dao;
import com.sist.web.entity.BoardEntity;
import com.sist.web.entity.GoodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.*;
public interface GoodsDAO extends JpaRepository<GoodsEntity, Integer> {
    @Query(value = "SELECT * FROM GOODS " +
            "WHERE name LIKE CONCAT('%',:name,'%') LIMIT :start, 12", nativeQuery = true)
    public List<GoodsEntity> goodsFindData(@Param("name") String name, @Param("start") Integer start);

    @Query(value = "SELECT CEIL(COUNT(*)/12.0) FROM GOODS " +
            "WHERE name LIKE CONCAT('%',:name,'%')", nativeQuery = true)
    public int goodsFindTotalPage(String name);


    public BoardEntity findByNo(int no);
}
