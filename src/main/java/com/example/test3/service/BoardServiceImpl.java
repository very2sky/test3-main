package com.example.test3.service;

import com.example.test3.domain.BoardDto;
import com.example.test3.mapper.BoardMapper;
import com.example.test3.paging.PaginationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardMapper boardMapper;

    @Override
    public boolean registerBoard(BoardDto params) {
        int queryResult = 0;

        if (params.getIdx() == null) {
            queryResult = boardMapper.insertBoard(params);
        } else {
            queryResult = boardMapper.updateBoard(params);
        }

        return (queryResult == 1) ? true : false;
    }

    @Override
    public BoardDto getBoardDetail(Long idx) {
        return boardMapper.selectBoardDetail(idx);
    }

    @Override
    public boolean deleteBoard(Long idx) {
        int queryResult = 0;

        BoardDto board = boardMapper.selectBoardDetail(idx);

        if (board != null && "N".equals(board.getDy())) {
            queryResult = boardMapper.deleteBoard(idx);
        }

        return (queryResult == 1) ? true : false;
    }

    @Override
    public List<BoardDto> getBoardList(BoardDto params) {
        List<BoardDto> boardList = Collections.emptyList();

        int boardTotalCount = boardMapper.selectBoardTotalCount(params);

        PaginationInfo paginationInfo = new PaginationInfo(params);
        paginationInfo.setTotalRecordCount(boardTotalCount);

        params.setPaginationInfo(paginationInfo);

        if (boardTotalCount > 0) {
            boardList = boardMapper.selectBoardList(params);
        }

        return boardList;
    }
}
