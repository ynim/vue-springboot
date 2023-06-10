package com.example.carbon.controller;

import com.example.carbon.domain.Gcjm;
import com.example.carbon.domain.Nxyj;
import com.example.carbon.domain.User;
import com.example.carbon.pojo.UserInfo;
import com.example.carbon.service.ZhInfoService;
import com.example.carbon.service.LoginServcie;
import com.example.carbon.util.JwtUtil;
import com.example.carbon.util.ResponseResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.lettuce.core.internal.LettuceLists;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class UserController {

    @Resource
    private LoginServcie loginServcie;

    @Autowired
    private StringRedisTemplate template;

    @Resource
    private ZhInfoService zhInfoService;

    @RequestMapping("/user/login")
    public ResponseResult login(@RequestBody User user) throws Exception {
        return loginServcie.login(user);
    }

    @RequestMapping("/user/info")
    public ResponseResult info(String token) throws Exception {
        String userid;
        try {
            Claims claims = JwtUtil.parseJWT(token);
            userid = claims.getSubject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("token非法");
        }
        //从redis中获取用户信息
        String redisKey = "login:" + userid;
        String userJson  = template.opsForValue().get(redisKey);
        ObjectMapper mapper = new ObjectMapper();
        User loginUser=mapper.readValue(userJson,User.class);
        UserInfo userInfo=new UserInfo();
        userInfo.setName(loginUser.getUsername());
        userInfo.setRoles(LettuceLists.newList("admin"));

        return ResponseResult.SUCCESS(userInfo);
    }

    @RequestMapping("/user/logout")
    public ResponseResult logout() {
        return loginServcie.logout();

    }



}
