package com.example.mybatisoraclesetting.modelVo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("SearchCriteria") //검색기능Vo  Criteria를 부모잡아서 페이징까지 같이 물려받아 사용가능
public class SearchCriteria extends Criteria{
    private String searchType = "";
    private String keyword = "";

    //저장할 생성자

    public void setSearchType(String searchType){
        this.searchType = searchType;
    }
    public void getSearchType(String searchType){
        this.searchType = searchType;
    }
    public void setKeyword(String keyword){
        this.keyword = keyword;
    }
}
