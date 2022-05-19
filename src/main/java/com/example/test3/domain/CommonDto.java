package com.example.test3.domain;


import com.example.test3.paging.PaginationInfo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommonDto extends Criteria{

    private PaginationInfo paginationInfo;

    private String dy; // deleteYN

    private LocalDateTime insertTime;
    private LocalDateTime updateTime;
    private LocalDateTime deleteTime;
}
