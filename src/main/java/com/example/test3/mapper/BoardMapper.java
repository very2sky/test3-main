package com.example.test3.mapper;

import com.example.test3.domain.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper{

    public int insertBoard(BoardDto params);

    public BoardDto selectBoardDetail(Long idx);

    public int updateBoard(BoardDto params);
    public int deleteBoard(Long idx);

    public List<BoardDto> selectBoardList(BoardDto params);

    public int selectBoardTotalCount(BoardDto params);


}