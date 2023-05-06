package com.example.mybatisoraclesetting.controller;

import com.example.mybatisoraclesetting.modelVo.UserVo;
import com.example.mybatisoraclesetting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/")
public class UserController {
    private final UserService userService;
    //private final BoardService boardService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "test")
    public ModelAndView list() throws Exception{
        List<UserVo> list = userService.listAll();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("userlist");
        mav.addObject("list",list);
        return mav;
    }
}