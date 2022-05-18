package com.example.test3;

import com.example.test3.domain.BoardDto;
import com.example.test3.mapper.BoardMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MapperTests {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void testOfInsert() {
        BoardDto params = new BoardDto();
        params.setTitle("1first title");
        params.setContent("first content");
        params.setWriter("tester");

        int result = boardMapper.insertBoard(params);
        System.out.println("reuslt is " + result);
    }

}