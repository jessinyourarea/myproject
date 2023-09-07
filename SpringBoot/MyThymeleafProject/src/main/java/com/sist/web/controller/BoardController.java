package com.sist.web.controller;

import com.sist.web.dao.BoardDAO;
import com.sist.web.entity.BoardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("board/")
public class BoardController {
    private BoardDAO dao;

    @Autowired
    public BoardController(BoardDAO dao) {
        this.dao = dao;
    }

    @GetMapping("board_list")
    public String board_list(String page, Model model)
    {
        if(page==null)
            page="1";
        int curpage = Integer.parseInt(page);
        int rowSize = 10;
        int start = (curpage-1)*rowSize; // Limit => 0부터 시작! +1붙이지 않음
        List<BoardEntity> list = dao.boardListData(start);
        for(BoardEntity vo:list)
        {
            String s = vo.getRegdate();
            String[] ss = s.split(" ");
            vo.setRegdate(ss[0].trim());
        }
        int totalpage=dao.boardTotalPage();
        model.addAttribute("totalpage", totalpage);
        model.addAttribute("curpage", curpage);
        model.addAttribute("list", list);
        model.addAttribute("main_html", "board/board_list");
        return "main";
    }

    @GetMapping("board_detail")
    public String board_detail(int no, Model model)
    {
        BoardEntity vo=dao.findByNo(no);
        vo.setHit(vo.getHit()+1);
        dao.save(vo); // update => save(): update,insert
        vo=dao.findByNo(no);
        model.addAttribute("vo",vo);
        model.addAttribute("main_html", "board/board_detail");
        return "main";
    }
}


