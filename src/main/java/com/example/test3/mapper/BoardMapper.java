package com.example.test3.mapper;

import com.example.test3.domain.BoardDto;
import com.example.test3.paging.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper        // Mapper라고 선언함
public interface BoardMapper{

    public int insertBoard(BoardDto params);

    public BoardDto selectBoardDetail(Long idx);

    public int updateBoard(BoardDto params);
    public int deleteBoard(Long idx);

    public List<BoardDto> selectBoardList(Criteria criteria);

    public int selectBoardTotalCount(Criteria criteria);





}