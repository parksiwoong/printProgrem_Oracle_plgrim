package com.example.mybatisoraclesetting.controller;

import com.example.mybatisoraclesetting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller(value = "/")
public class MainController {

    private final UserService userService;


    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String main(HttpServletRequest request, HttpServletResponse response) {
        return "board/index";
    }

   /* @RequestMapping(value = "kakaomap", method = RequestMethod.GET)
    public String mapGet(HttpServletRequest request, HttpServletResponse response) {
        return "kakao/kakaomap";
    }
*/
    @ExceptionHandler
    public void hendleException(HttpServletResponse response, Exception exception) {
        try {
            response.getWriter().print(exception.getMessage());
        } catch (Exception ignored) {
        }
    }

}
