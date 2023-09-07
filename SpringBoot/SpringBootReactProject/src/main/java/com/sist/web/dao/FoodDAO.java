package com.sist.web.dao;

import com.sist.web.entity.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodDAO extends JpaRepository<FoodEntity, Integer> {
    public FoodEntity findByFno(int fno);

    public List<FoodEntity> findByCno(int cno);
}