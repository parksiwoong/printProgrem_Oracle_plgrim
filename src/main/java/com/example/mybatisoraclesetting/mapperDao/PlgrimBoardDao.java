package com.example.mybatisoraclesetting.mapperDao;

import com.example.mybatisoraclesetting.modelVo.PlgrimVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlgrimBoardDao {
    List selectTakeOutList(PlgrimVo vo) throws Exception;
}
