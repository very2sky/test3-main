package com.example.test3.paging;

import lombok.Data;

@Data
public class Criteria {
    private int currentPageNo;
    private int recordsPerPage;
    private int pageSize;
    private String searchKeyword;
    private String searchType;
    public Criteria(){
        this.currentPageNo=1;
        this.recordsPerPage=5;
        this.pageSize=5;
    }
    public int getStartPage(){
        return (currentPageNo-1) * recordsPerPage;
    }
}
