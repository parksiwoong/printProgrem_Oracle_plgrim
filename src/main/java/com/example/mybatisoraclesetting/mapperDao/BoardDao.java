package com.example.mybatisoraclesetting.mapperDao;

import com.example.mybatisoraclesetting.modelVo.BoardVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardDao {
    List<BoardVo> boardListAll(BoardVo boardVo)throws Exception;
}
