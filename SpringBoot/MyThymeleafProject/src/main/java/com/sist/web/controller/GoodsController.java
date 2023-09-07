package com.sist.web.controller;

import com.sist.web.dao.GoodsDAO;
import com.sist.web.entity.GoodsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("goods/")
public class GoodsController {
    @Autowired
    private GoodsDAO dao;
    @GetMapping("list")
    public String goods_find(String fd, String page, Model model)
    {
        if(fd==null)
            fd="건강";
        if(page == null)
            page = "1";
        int curpage = Integer.parseInt(page);
        int rowSize = 20;
        int start = (curpage-1)*rowSize;
        List<GoodsEntity> list=dao.goodsFindData(fd,start);
        int totalpage = dao.goodsFindTotalPage(fd);

        final int BLOCK = 10;
        int startpage = (curpage-1)/BLOCK*BLOCK+1;
        int endpage = (curpage-1)/BLOCK*BLOCK+BLOCK;
        if(endpage>totalpage)
            endpage=totalpage;

        model.addAttribute("curpage", curpage);
        model.addAttribute("totalpage", totalpage);
        model.addAttribute("startpage", startpage);
        model.addAttribute("endpage", endpage);
        model.addAttribute("list", list);
        model.addAttribute("fd", fd);
        model.addAttribute("main_html","/goods/goods_list");
        return "main";
    }
}
