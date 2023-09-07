package com.sist.web.controller;

import com.sist.web.dao.RentDAO;
import com.sist.web.entity.*;
import com.sist.web.entity.RentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("http://localhost:3000") // 새로운 포트 허용 어노테이션
public class RentRestController {
    @Autowired
    private RentDAO dao;

    @GetMapping("cars")
    public Map<String, Object> getCarData(String page, String carName, String maker){
        page = (page==null) ? "1" : page;
        carName = (carName==null) ? "" : carName;
        maker = (maker==null) ? "" : maker;

        int curpage = Integer.parseInt(page);

        PageRequest pageRequest = PageRequest.of(curpage-1, 12);
        Page<RentEntity> result = dao.findByCarNameContainsAndMakerContains(carName, maker, pageRequest);

        Map<String, Object> retval = new HashMap<>();
        retval.put("totalpage", result.getTotalPages());
        retval.put("list", result.getContent());

        return retval;
    }
}
