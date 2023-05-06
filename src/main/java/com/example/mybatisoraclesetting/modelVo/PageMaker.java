package com.example.mybatisoraclesetting.modelVo;

import com.sun.deploy.net.URLEncoder;
import lombok.Data;
import org.apache.ibatis.type.Alias;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;

@Data
@Alias("PageMaker")
public class PageMaker {
/* 페이지 처리 간단 요약
    페이지 번호 출력 처리를 위한 데이터들 : 시작페이지번호, 끝 페이지 번호 , 전체 게시글의 갯수, 이전링크 , 다음링크
    끝 페이지 번호 계산식 : Math.ceil(현재 페이지 번호 / 페이지 번호의 갯수) * 페이지번호의 갯수
    시작 페이지 번호 계산식 : (끝 페이지 번호 - 페이지 번호의 갯수) + 1
    끝 페이지 번호의 보정 계산식 : Math.ceil(전체 게시글의 갯수 / 페이지 당 출력할 게시글의 갯수)
    이전 링크 활성/비활성 계산식 : 시작 페이지 번호 == 1 ? fales : true
    다음 링크 활성/비활성 계산식: 끝 페이지 번호 * 페이지 당 출력할 게시글 갯수 >= 전체 게시글의 갯수 ? fales : true
* */
    private int totalCount; // 전체 게시글의 갯수 //db에서 계산되는 데이터
    private int startPage; //지금페이지 //계산식을 통해 만들어지는 데이터
    private int endPage;    // 끝 페이지 번호 //계산식을 통해 만들어지는 데이터
    private boolean prev; // 이전 링크
    private boolean next; //다음 링크

    private int displayPageNum = 10; // 하단의 페이지 번호의 갯수를 의미

    private Criteria criteria; // 게시글의 전체 갯수가 설정되는 시점에 calcData() 메서드를 호출하여 필요한 데이터들을 계산

    public void setCriteria(Criteria criteria) {
        this.criteria = criteria;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        calcData();
    }

    private void calcData() {
        //끝 페이지 번호 보정 계산식
        //끝 페이지 번호 = Math.ceil( 전체 게시글 수 / 페이지 당 출력할 게시글의 수
         endPage = (int) (Math.ceil(criteria.getPage() / (double)displayPageNum) * displayPageNum);
        // 시작 페이지 번호 = (끝 페이지 번호 - 페이지 번호의 갯수) + 1
         startPage = (endPage - displayPageNum) + 1;

        int tempEndPage = (int) (Math.ceil(totalCount / (double)criteria.getPerPageNum()));
        // 이전의 결과 값과 보정된 결과 값을 비교 후 , 보정한 결과 값을 페이지 끝번호 변수에 저장
        if (endPage > tempEndPage) {
            endPage = tempEndPage;
        }

        prev = startPage == 1 ? false : true;
        next = endPage * criteria.getPerPageNum() >= totalCount ? false : true;
    }

  public String makeQuery(int page) {
        UriComponents uriComponents =
                UriComponentsBuilder.newInstance()
                        .queryParam("page", page)
                        .queryParam("perPageNum", criteria.getPerPageNum())
                        .build();

        return uriComponents.toUriString();
    }
    // 검색어 관련
    public String makeSearch(int page)
    {
        // page, perPageNum, searchType, keyword를 url로 사용할수있게
        UriComponents uriComponents =
                UriComponentsBuilder.newInstance()
                        .queryParam("page", page)
                        .queryParam("perPageNum", criteria.getPerPageNum())
                        .queryParam("searchType", ((SearchCriteria)criteria).getSearchType())
                        .queryParam("keyword", encoding(((SearchCriteria)criteria).getKeyword()))
                        .build();
        return uriComponents.toUriString();
    }

    private String encoding(String keyword) {
        if(keyword == null || keyword.trim().length() == 0) {
            return "";
        }

        try {
            return URLEncoder.encode(keyword, "UTF-8");
        } catch(UnsupportedEncodingException e) {
            return "";
        }
    }
}