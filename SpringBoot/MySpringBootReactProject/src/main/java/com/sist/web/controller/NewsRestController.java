package com.sist.web.controller;

import com.sist.web.entity.NewsVO;
import com.sist.web.manager.NewsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("news/")
@CrossOrigin("http://localhost:3000")
public class NewsRestController {
    @Autowired
    private NewsManager mgr;

    @GetMapping("news_find_react")
    public List<NewsVO> news_find_react(String fd)
    {
        List<NewsVO> list=mgr.newsFind(fd);
        return list;
    }
}
