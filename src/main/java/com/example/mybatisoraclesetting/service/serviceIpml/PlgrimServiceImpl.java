package com.example.mybatisoraclesetting.service.serviceIpml;

import com.example.mybatisoraclesetting.mapperDao.BoardDao;
import com.example.mybatisoraclesetting.mapperDao.PcDataDao;
import com.example.mybatisoraclesetting.mapperDao.PlgrimBoardDao;
import com.example.mybatisoraclesetting.modelVo.PlgrimVo;
import com.example.mybatisoraclesetting.service.PlgrimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("plgrimService")
public class PlgrimServiceImpl implements PlgrimService {
    private PlgrimBoardDao dao;

    @Autowired
    public PlgrimServiceImpl(PlgrimBoardDao dao){this.dao = dao;}

    public List selectTakeOutList(PlgrimVo vo) throws Exception{
        return dao.selectTakeOutList(vo);
    }
}
