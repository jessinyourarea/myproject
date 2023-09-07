package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.*;
import com.sist.web.dao.*;
import com.sist.web.entity.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("board_insert")
    public String board_insert(Model model)
    {
        model.addAttribute("main_html","board/board_insert");
        return "main";
    }

    @PostMapping("board_insert_ok")
    public String board_insert_ok(BoardEntity vo)
    {
        dao.save(vo);
        return "redirect:board_list";
    }

    @GetMapping("board_update")
    public String board_update(int no, Model model)
    {
        BoardEntity vo=dao.findByNo(no);
        model.addAttribute("vo", vo);
        model.addAttribute("main_html","board/board_update");
        return "main";
    }

    @PostMapping("board_update_ok")
    public String board_update_ok(BoardEntity vo, RedirectAttributes ra)
    {
        BoardEntity tvo=dao.findByNo(vo.getNo());
        vo.setHit(tvo.getHit());
        dao.save(vo);
        ra.addAttribute("no",vo.getNo());
        return "redirect:/board/board_detail";
    }

    @GetMapping("board_delete")
    public String board_delete(int no, Model model)
    {
        model.addAttribute("no",no);
        model.addAttribute("main_html","board/board_delete");
        return "main";
    }

    @PostMapping("board_delete_ok")
    public String board_delete_ok(String pwd, int no)
    {
        BoardEntity vo=dao.findByNo(no);
        dao.delete(vo);
        return "redirect:/board/board_list";
    }
}
