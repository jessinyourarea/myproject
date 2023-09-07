package com.sist.web.dao;

import com.sist.web.entity.CategoryVO;
import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public interface FoodCategoryDAO extends JpaRepository<CategoryVO, Integer> {
    @Query(value = "SELECT cno, title, poster, subject, link FROM food_category", nativeQuery = true)
    public List<CategoryVO> categoryListData();
}
