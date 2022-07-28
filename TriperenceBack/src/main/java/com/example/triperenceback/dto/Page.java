package com.example.triperenceback.dto;

public class Page {
    /** 한 페이지당 게시글 수 **/
    private int pageSize = 20;
    private int rangeSize = 5;
    private int curPage = 1;
    private int curRange = 1;
    private int listCnt;
    private int pageCnt;
    /** 총 블럭(range) 수 **/
    private int rangeCnt;

    /** 시작 페이지 **/
    private int startPage = 1;

    /** 끝 페이지 **/
    private int endPage = 1;

    /** 시작 index **/
    private int startIndex = 0;

    /** 이전 페이지 **/
    private int prevPage;

    /** 다음 페이지 **/
    private int nextPage;
}
