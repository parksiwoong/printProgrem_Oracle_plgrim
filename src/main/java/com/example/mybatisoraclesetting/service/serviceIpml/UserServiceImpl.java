package com.example.mybatisoraclesetting.service.serviceIpml;



import com.example.mybatisoraclesetting.mapperDao.UserDao;
import com.example.mybatisoraclesetting.modelVo.UserVo;
import com.example.mybatisoraclesetting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<UserVo> listAll() throws Exception{
        return userDao.listAll();
    }
}
