package com.example.mybatisoraclesetting.controller;

import com.example.mybatisoraclesetting.modelVo.BoardVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller(value = "/plgrim")
public class PlgrimGetBoardController {

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
     * 반출신청 화면페이지
     * */
    @RequestMapping(value = "/takeOut.json")
    @ResponseBody
    public String takeOutJson( HttpServletRequest request, HttpServletResponse response ,BoardVo boardVo, Map map) throws Exception {
        Model model = new ModelMap();
        model.addAttribute("",);
        return "map";
    }
}
