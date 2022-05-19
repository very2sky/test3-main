package com.example.test3.paging;


import com.example.test3.domain.Criteria;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginationInfo {
    private Criteria criteria;
    private int totalRecordCount;
    private int totalPageCount;
    private int firstPage;//첫
    private int lastPage;//마지막
    private int firstRecordIndex;
    private int lastRecordIndex;
    private boolean hasPreviousPage;//이전꺼 존재여부
    private boolean hasNextPage;

    public PaginationInfo(Criteria criteria) {
        if (criteria.getCurrentPageNo() < 1) {
            criteria.setCurrentPageNo(1);
        }
        if (criteria.getRecordsPerPage() < 1 || criteria.getRecordsPerPage() > 100) {
            criteria.setRecordsPerPage(10);
        }
        if (criteria.getPageSize() < 5 || criteria.getPageSize() > 20) {
            criteria.setPageSize(10);
        }

        this.criteria = criteria;
    }

    public void setTotalRecordCount(int totalRecordCount) {
        this.totalRecordCount = totalRecordCount;

        if (totalRecordCount > 0) {
            calculation();
        }
    }

    private void calculation() {

        totalPageCount = ((totalRecordCount - 1) / criteria.getRecordsPerPage()) + 1;
        if (criteria.getCurrentPageNo() > totalPageCount) {
            criteria.setCurrentPageNo(totalPageCount);
        }
        firstPage = ((criteria.getCurrentPageNo() - 1) / criteria.getPageSize()) * criteria.getPageSize() + 1;

        /* 페이지 리스트의 마지막 페이지 번호 (마지막 페이지가 전체 페이지 수보다 크면 마지막 페이지에 전체 페이지 수를 저장) */
        lastPage = firstPage + criteria.getPageSize() - 1;
        if (lastPage > totalPageCount) {
            lastPage = totalPageCount;
        }

        /* SQL의 조건절에 사용되는 첫 RNUM */
        firstRecordIndex = (criteria.getCurrentPageNo() - 1) * criteria.getRecordsPerPage();

        /* SQL의 조건절에 사용되는 마지막 RNUM */
        lastRecordIndex = criteria.getCurrentPageNo() * criteria.getRecordsPerPage();

        /* 이전 페이지 존재 여부 */
        hasPreviousPage = firstPage != 1;

        /* 다음 페이지 존재 여부 */
        hasNextPage = (lastPage * criteria.getRecordsPerPage()) < totalRecordCount;
    }

}
