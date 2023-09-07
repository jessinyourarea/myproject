package com.sist.web.dao;

import com.sist.web.entity.RentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.*;

@Repository
public interface RentDAO extends JpaRepository<RentEntity, Integer> {
    Page<RentEntity> findByCarNameContainsAndMakerContains(String carName, String maker, Pageable pageable);
}
