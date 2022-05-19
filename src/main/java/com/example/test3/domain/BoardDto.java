package com.example.test3.domain;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BoardDto extends CommonDto{
    private Long idx;// pk
    private String title;// 제목
    private String content;//내용
    private String writer;


    @Override
    public String toString() {
        return "BoardDto{" +
                "idx=" + idx +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }
}
