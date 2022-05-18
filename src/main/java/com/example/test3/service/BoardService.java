package com.example.test3.service;

import com.example.test3.domain.BoardDto;
import com.example.test3.paging.Criteria;

import java.util.List;

public interface BoardService {

  public boolean registerBoard(BoardDto params);

    public BoardDto getBoardDetail(Long idx);

    public boolean deleteBoard(Long idx);

    public List<BoardDto> getBoardList(Criteria criteria);

}