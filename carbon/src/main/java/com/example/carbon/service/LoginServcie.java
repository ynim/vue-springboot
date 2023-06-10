package com.example.carbon.service;

import com.example.carbon.domain.User;
import com.example.carbon.util.ResponseResult;

import java.util.List;

public interface LoginServcie {
    ResponseResult login(User user) throws Exception;

    public ResponseResult logout();

    public List<User> queryUserList();

}
