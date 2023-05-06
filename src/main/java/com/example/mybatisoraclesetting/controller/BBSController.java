package com.example.mybatisoraclesetting.controller;


import com.example.mybatisoraclesetting.modelVo.*;
import com.example.mybatisoraclesetting.service.BoardService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;


@Controller
@RequestMapping(value = "/")
public class BBSController {
    //log4j2 사용
    private static final Logger logger = LogManager.getLogger(BBSController.class);
     private BoardService boardService;

    @Autowired
    public BBSController(BoardService boardService){
        this.boardService = boardService;
    }


    //test
    @RequestMapping(value = "datalist")
    public ModelAndView boardlist(HttpServletRequest request, HttpServletResponse response , BoardVo boardVo) throws Exception {
        ModelAndView mav = new ModelAndView();
        List<BoardVo> boardlist = boardService.boardListAll(boardVo);
        logger.info(boardlist + "2들어갔니");
      try {
            logger.info("board in");
            logger.info(boardlist + "들어갔니");
            mav.addObject("boardlist", boardlist);
            mav.setViewName("board/datalist");

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("############ SQLException ############");
        }
        return mav;
    }

    // 게시판 데이터 리스트
    @RequestMapping(value = "{url}")
    public ModelAndView pcdatalist(HttpServletRequest request,HttpServletResponse response,
                                   @ModelAttribute("scri") SearchCriteria scri,@PathVariable("url")String url
                                   )throws Exception{
        ModelAndView mav = new ModelAndView();

        PageMaker pageMaker = new PageMaker();
        pageMaker.setCriteria(scri);  // set에 pagemaker의 로직에 정보를 집어넣어줘야함
        pageMaker.setTotalCount(boardService.listCount(scri)); //총게시물수

        List<PcDataVo> datalist = boardService.pcDataList(scri); // 목록
        System.out.println(pageMaker + "pageMaker");


        logger.info(datalist + "2들어갔니");
        try {
            logger.info("board in");
            logger.info(datalist + "들어갔니");
            mav.addObject("datalist", datalist); // 리스트기능
            mav.addObject("pageMaker", pageMaker); //페이지기능

            //mav.addObject("scri",scri); //검색기능

            //       mav.addObject("read",boardService.read(pcDataVo.getBno())); //검색찾을 번호 호출
            if(url.equals( "pclist")){
                mav.setViewName("board/datalist");
            }else if (url.equals("tablelist")){
                mav.setViewName("board/tablelist");
            }


        } catch (Exception e) {
            e.printStackTrace();
            logger.error("############ SQLException ############");
        }
        return mav;
    }

    // raw data AJAX 로 받아왔을때 @RequestBody
    //,method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE
    @RequestMapping(value = "dtsave")
    @ResponseBody
    //public Object insert(@ModelAttribute("") PcDataVo pcDataVo)throws Exception{
    public Object insert(@RequestBody PcDataVo param, HttpServletRequest request )throws Exception{
        logger.info("###"+param);
       // String no =  param.get("no").toString();
        // ==
        // no = request.getParameter("no");

//
//        List<String> ssds =(List<String>) param.get("ssd");
//        for(int i=0; i<ssds.size(); i++){
//            System.out.println(String.format("%d\t%s", i, ssds.get(i)));
//        }

        /*
        String[] ssds =(String[]) param.get("ssd");
        // ==
        ssds = request.getParameterValues("ssd");
        */


        System.out.println(param);


        return boardService.create(param) ;//boardService.create(pcDataVo);boardService.create(param)
    }

    //,method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE
    @RequestMapping(value = "submits") //submit 으로 받을때 submit은 name으로 전달
    @ResponseBody
    //public Object insert(@ModelAttribute("") PcDataVo pcDataVo)throws Exception{
    public Object submits(@ModelAttribute("pageInfo") PcDataVo pcDataVo)throws Exception{
        System.out.println(pcDataVo);

/*
        for(int i=0; i<   pcDataVo.getSsd().length; i++){
            System.out.println(String.format("%d\t%s", i, pcDataVo.getSsd()[i]));
        }*/

        return  boardService.submitinsert(pcDataVo);//boardService.create(pcDataVo);
    }

    // 데이터 삭제
    @ResponseBody
    @RequestMapping(value = "deleteData", method = RequestMethod.POST)
    public int deleteData(@RequestParam(value = "chBox[]", required=false)List<String> chArr , PcDataVo pcDataVo) throws Exception {
        logger.info("delete data", chArr);
        System.out.println(chArr);
        int result= 0;
        int dataBno = 0;

        if(!chArr.isEmpty()) {          //비어있지않다면
            for (String i : chArr) {            // 반복해서 chArr 의 길이만큼 (i 는 chArr에 들어있는 chBox[] 객체들)
                System.out.println(i+ "뭔지확인");
                dataBno = Integer.parseInt(i);   // json 을 인티저 타입으로 변형해 빈객체 dataNo 에 넣어줌
                pcDataVo.setBno(dataBno);         // 넣어준dataNo 를 Vo no 에 다시 넣어줌
                boardService.deleteData(pcDataVo);
            }
            result = 1; // 성공시  ajax 로 1반환
        }
        return result;
    };
}
