package com.example.mybatisoraclesetting.service;



import com.example.mybatisoraclesetting.modelVo.UserVo;

import java.util.List;


public interface UserService {
    public List<UserVo> listAll() throws Exception;
}