package com.example.test3.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Getter
@Setter
public class Criteria {

    private int currentPageNo;

    private int recordsPerPage;

    private int pageSize;

    /** 검색 키워드 */
    private String searchKeyword;

    /** 검색 유형 */
    private String searchType;

    public Criteria() {
        this.currentPageNo = 1;
        this.recordsPerPage = 5;
        this.pageSize = 5;
    }

    public String makeQueryString(int pageNo) {

        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .queryParam("currentPageNo", pageNo)
                .queryParam("recordsPerPage", recordsPerPage)
                .queryParam("pageSize", pageSize)
                .queryParam("searchType", searchType)
                .queryParam("searchKeyword", searchKeyword)
                .build()
                .encode();

        return uriComponents.toUriString();
    }

}