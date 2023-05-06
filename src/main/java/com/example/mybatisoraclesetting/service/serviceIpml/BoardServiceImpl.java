package com.example.mybatisoraclesetting.service.serviceIpml;

import com.example.mybatisoraclesetting.mapperDao.BoardDao;
import com.example.mybatisoraclesetting.mapperDao.PcDataDao;
import com.example.mybatisoraclesetting.modelVo.BoardVo;
import com.example.mybatisoraclesetting.modelVo.Criteria;
import com.example.mybatisoraclesetting.modelVo.PcDataVo;
import com.example.mybatisoraclesetting.modelVo.SearchCriteria;
import com.example.mybatisoraclesetting.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("BoardService")
public class BoardServiceImpl implements BoardService{
    private BoardDao boardDao;
    private PcDataDao pcDataDao;

    @Autowired
    public BoardServiceImpl(BoardDao boardDao,
                            PcDataDao pcDataDao){
        this.boardDao = boardDao;
        this.pcDataDao = pcDataDao;
    };

    @Override
    public List<BoardVo> boardListAll(BoardVo boardVo)throws Exception {
        return boardDao.boardListAll(boardVo);
    }
    // 게시물 목록 조회
    @Override
    public List<PcDataVo> pcDataList(SearchCriteria scri)throws Exception{
        return pcDataDao.pcDataList(scri);
    }
    // 총 게시물 겟수
    @Override
    public int listCount(SearchCriteria scri) throws Exception {
        return pcDataDao.listCount(scri);
    }

    @Override
    public int create(PcDataVo param) throws Exception {
        System.out.println(param +"서비스");
        return pcDataDao.create(param);
    }

    @Override
    public int submitinsert(PcDataVo pcDataVo) throws Exception {
        return pcDataDao.submitinsert(pcDataVo);
    }

    // 데이터 삭제
    @Override
    public void deleteData(PcDataVo pcDataVo) throws Exception {
         pcDataDao.deleteData(pcDataVo);
    }
}
