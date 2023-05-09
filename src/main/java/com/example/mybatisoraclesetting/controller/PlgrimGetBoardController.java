package com.example.mybatisoraclesetting.controller;

import com.example.mybatisoraclesetting.modelVo.BoardVo;
import com.example.mybatisoraclesetting.modelVo.PlgrimVo;
import com.example.mybatisoraclesetting.service.PlgrimService;
import com.example.mybatisoraclesetting.service.serviceIpml.PlgrimServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/plgrim")
public class PlgrimGetBoardController {
    Logger log = LoggerFactory.getLogger(String.class);
    @Resource(name = "plgrimService")
    PlgrimService plgrimService;
    /**
     * 반출신청 화면페이지
     * */
    @RequestMapping(value = "/takeOut")
    public ModelAndView takeOut(HttpServletRequest request, HttpServletResponse response , BoardVo boardVo) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("board/takeOut");
        return mav;
    }
    /**
     * vpn 화면페이지
     * */
    @RequestMapping(value = "/takeOutVpn")
    public ModelAndView takeOutVpn(HttpServletRequest request, HttpServletResponse response , BoardVo boardVo) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("board/takeOutVpn");
        return mav;
    }
    /**
     * 반출신청 화면페이지
     * */

   /* @ResponseBody*/
    @RequestMapping(value = "/takeOutJson")
    public ModelAndView takeOutJson(PlgrimVo vo, HttpServletRequest request, HttpServletResponse response) throws Exception {
        log.info("takeOutJson in ::: {}",vo.getPlgrimNm());
        String sel = vo.getPlgrimNm();
        ModelMap model = new ModelMap();
        List list =  plgrimService.selectTakeOutList(vo);
        model.addAttribute("list",list);
        model.addAttribute("sel",sel);
        return new ModelAndView("board/takeOut",model);
    }
}
