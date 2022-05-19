package com.example.test3.service;

import com.example.test3.domain.BoardDto;

import java.util.List;

public interface BoardService {

  public boolean registerBoard(BoardDto params);

    public BoardDto getBoardDetail(Long idx);

    public boolean deleteBoard(Long idx);

    public List<BoardDto> getBoardList(BoardDto params);

}