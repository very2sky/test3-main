package com.example.test3.controller;

import com.example.test3.domain.BoardDto;
import com.example.test3.paging.Criteria;
import com.example.test3.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoardController {
//
  @Autowired
   private BoardService boardService;


    @GetMapping(value = "/board/write")
    public String openBoardWrite(@RequestParam(value = "idx", required = false) Long idx, Model model) {
        if (idx == null) {
            model.addAttribute("board", new BoardDto());
        } else {
            BoardDto board = boardService.getBoardDetail(idx);
            if (board == null) {
                return "redirect:/board/list";
            }
            System.out.println(board);
            model.addAttribute("board", board);
        }

        return "/board/write";
    }

    @PostMapping(value = "/board/register")//*************************************************************************** update
    public String registerBoard(final BoardDto params) {
        System.out.println("djqepdlxm");
        System.out.println(params);
        boardService.registerBoard(params);
        return "redirect:/board/list";
    }

    @GetMapping(value = "/board/list")
    public String openBoardList(@ModelAttribute("criteria") Criteria criteria,Model model) {
        List<BoardDto> boardList = boardService.getBoardList(criteria);
        model.addAttribute("boardList", boardList);
        return "/board/list";
    }
    @GetMapping(value = "/board/view")
    public String openBoardDetail(@RequestParam(value = "idx", required = false) Long idx, Model model) {
        if (idx == null) {
            System.out.print("뷰idx 가 없어요");
            return "redirect:/board/list";
        }

        BoardDto board = boardService.getBoardDetail(idx);
        if (board == null || "Y".equals(board.getDy())) {
            return "redirect:/board/list";
        }
        model.addAttribute("board", board);

        return "board/view";
    }

    @PostMapping(value = "/board/delete")
    public String deleteBoard(@RequestParam(value = "idx", required = true) Long idx) {
        if (idx == null) {
            System.out.print("delete idx 가 없어요");
            return "redirect:/board/list";
        }
        boardService.deleteBoard(idx);

        return "redirect:/board/list";
    }


}
