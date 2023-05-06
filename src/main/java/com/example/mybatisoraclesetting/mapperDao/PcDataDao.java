package com.example.mybatisoraclesetting.mapperDao;

import com.example.mybatisoraclesetting.modelVo.Criteria;
import com.example.mybatisoraclesetting.modelVo.PcDataVo;
import com.example.mybatisoraclesetting.modelVo.SearchCriteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PcDataDao {
    List<PcDataVo> pcDataList(SearchCriteria scri)throws Exception;
    int listCount(SearchCriteria scri) throws Exception;
    int create(PcDataVo param)throws Exception;
    int submitinsert(PcDataVo pcDataVo)throws Exception;
    void deleteData(PcDataVo pcDataVo)throws Exception;
}
