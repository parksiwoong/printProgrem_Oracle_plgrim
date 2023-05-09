package com.example.mybatisoraclesetting.service;

import com.example.mybatisoraclesetting.modelVo.PlgrimVo;

import java.util.List;

public interface PlgrimService {
    public List selectTakeOutList(PlgrimVo vo) throws Exception;
}
